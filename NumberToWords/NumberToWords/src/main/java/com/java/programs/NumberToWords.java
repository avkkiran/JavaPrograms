package com.java.programs;

public class NumberToWords implements Constants, INumberToWords {
    public String convertLessThanOneThousand(int number) {
        String currentNumberInWords = null;
        
        if (number % 100 < 20){
            currentNumberInWords = belowTwentyNames[number % 100];
            number /= 100;
        }
        else {
            currentNumberInWords = belowTwentyNames[number % 10];
            number /= 10;
            
            currentNumberInWords = tensNames[number % 10] + currentNumberInWords;
            number /= 10;
        }
        if (number == 0) 
        	return currentNumberInWords;
        return belowTwentyNames[number] + " hundred" + AND_CLAUSE + currentNumberInWords;
    }
    
    public void checkPreConditions(int number) throws Exception {
    	if(number > 999999999) {
        	throw new Exception(EXCEEDED_SUPPORTED_NUM_RANGE_EXCEPTION);
        }
        if(number < -999999999) {
        	throw new Exception(EXCEEDED_NEGATIVE_SUPPORTED_NUM_RANGE_EXCEPTION);
        }
    }
    
    public String convert(int number) throws Exception {
        if (number == 0) {
        	return "zero"; 
        }
        checkPreConditions(number);
        
        String prefix = "";
        
        if (number < 0) {
            number = -number;
            prefix = "negative";
        } 
        
        String currentNumberInWords = "";
        int place = 0;
        
        try {
        	do {
                int n = number % 1000;
                if (n != 0){
                    String s = convertLessThanOneThousand(n);
                    currentNumberInWords = s + aboveHundredNames[place++] + currentNumberInWords;
                }
                number /= 1000;
            } while (number > 0);
        	if(currentNumberInWords.endsWith(AND_CLAUSE)) {
            	currentNumberInWords = currentNumberInWords.replace(AND_CLAUSE, "");
            }
        } catch(ArithmeticException ae) {
        	throw new ArithmeticException("Arithmetic exception while converting number to words. The exception is: " + ae.getMessage());
        } catch(Exception e) {
        	throw new Exception("Failed to convert number to words. The exception is: " + e.getMessage());
        }        
        
        return (prefix + currentNumberInWords).trim();
    }
}
