package com.java.programs;

public class NumberToWords implements Constants {
    private String convertLessThanOneThousand(int number) {
        String current = null;
        
        if (number % 100 < 20){
            current = numNames[number % 100];
            number /= 100;
        }
        else {
            current = numNames[number % 10];
            number /= 10;
            
            current = tensNames[number % 10] + current;
            number /= 10;
        }
        if (number == 0) 
        	return current;
        return numNames[number] + " hundred and" + current;
    }
    
    public String convert(int number) {
        if (number == 0) { return "zero"; }
        
        String prefix = "";
        
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
                    current = s + specialNames[place++] + current;
                }
                number /= 1000;
            } while (number > 0);
        	if(current.endsWith("and")) {
            	current = current.replace(" and", "");
            }
        } catch(ArithmeticException ae) {
        	System.out.println("Arithmetic exception while converting number to words. The exception is: " + ae.getMessage());
        } catch(Exception e) {
        	System.out.println("Failed to convert number to words. The exception is: " + e.getMessage());
        }        
        
        return (prefix + current).trim();
    }
}
