package com.java.programs;

public class NumberToWords implements Constants {
    public String convertLessThanOneThousand(int number) {
        String current = null;
        
        if (number % 100 < 20){
            current = belowTwentyNames[number % 100];
            number /= 100;
        }
        else {
            current = belowTwentyNames[number % 10];
            number /= 10;
            
            current = tensNames[number % 10] + current;
            number /= 10;
        }
        if (number == 0) 
        	return current;
        return belowTwentyNames[number] + " hundred" + AND_CLAUSE + current;
    }
    
    public String convert(int number) throws Exception {
        if (number == 0) { 
        	return "zero"; 
        }
        
        String prefix = "";
        
        if(number > 999999999) {
        	throw new Exception(EXCEEDED_SUPPORTED_NUM_RANGE_EXCEPTION);
        }
        if(number < -999999999) {
        	throw new Exception(EXCEEDED_NEGATIVE_SUPPORTED_NUM_RANGE_EXCEPTION);
        }
        if (number < 0) {
            number = -number;
            prefix = "negative";
        } 
        
        String current = "";
        int place = 0;
        
        try {
        	do {
                int n = number % 1000;
                if (n != 0){
                    String s = convertLessThanOneThousand(n);
                    current = s + aboveHundredNames[place++] + current;
                }
                number /= 1000;
            } while (number > 0);
        	if(current.endsWith(AND_CLAUSE)) {
            	current = current.replace(AND_CLAUSE, "");
            }
        } catch(ArithmeticException ae) {
        	throw new ArithmeticException("Arithmetic exception while converting number to words. The exception is: " + ae.getMessage());
        } catch(Exception e) {
        	throw new Exception("Failed to convert number to words. The exception is: " + e.getMessage());
        }        
        
        return (prefix + current).trim();
    }
}
