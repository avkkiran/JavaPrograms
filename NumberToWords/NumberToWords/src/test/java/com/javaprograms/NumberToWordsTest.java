package com.javaprograms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.java.programs.NumberToWords;

/**
 * Unit test for NumberToWords.
 */
public class NumberToWordsTest 
{
	NumberToWords numberToWords = new NumberToWords();
	
    @Test
    public void testZero()
    {
    	String numberInWord = numberToWords.convert(0);
    	assertEquals("Expected zero but got "+numberInWord, "zero", numberInWord);
    }
    
    @Test
    public void testOne()
    {
    	String numberInWord = numberToWords.convert(1);
    	assertEquals("one", numberInWord);
    }
    
    @Test
    public void testNumberInTens()
    {
    	String numberInWord = numberToWords.convert(16);
    	assertEquals("sixteen", numberInWord);
    }
    
    @Test
    public void testEdgeNumberInHundreds()
    {
    	String numberInWord = numberToWords.convert(100);
    	assertEquals("one hundred", numberInWord);
    }
    
    @Test
    public void testNumberInHundreds()
    {
    	String numberInWord = numberToWords.convert(116);
    	assertEquals("one hundred and sixteen", numberInWord);
    }
    
    @Test
    public void testNumberInThousands()
    {
    	String numberInWord = numberToWords.convert(1316);
    	assertEquals("one thousand three hundred and sixteen", numberInWord);
    }
    
    @Test
    public void testNumberInTenThousands()
    {
    	String numberInWord = numberToWords.convert(10501);
    	assertEquals("ten thousand five hundred and one", numberInWord);
    }
    
    @Test
    public void testNumberInHundredThousand()
    {
    	String numberInWord = numberToWords.convert(100509);
    	assertEquals("one hundred and thousand five hundred and nine", numberInWord);
    }
    
    @Test
    public void testNumberInMillion()
    {
    	String numberInWord = numberToWords.convert(1005004);
    	assertEquals("one million five thousand four", numberInWord);
    }
    
    @Test
    public void testNumberInTensMillion()
    {
    	String numberInWord = numberToWords.convert(99899899);
    	assertEquals("ninety nine million eight hundred and ninety nine thousand eight hundred and ninety nine", numberInWord);
    }
    
    @Test
    public void testNumberInHundredMillion()
    {
    	String numberInWord = numberToWords.convert(999999999);
    	assertEquals("nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine", numberInWord);
    }
    
    @Test
    public void testNegativeNumberInHundredMillion()
    {
    	String numberInWord = numberToWords.convert(-999999999);
    	assertEquals("negative nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine", numberInWord);
    }
}
