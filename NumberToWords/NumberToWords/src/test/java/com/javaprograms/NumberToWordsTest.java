package com.javaprograms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.java.programs.Constants;
import com.java.programs.INumberToWords;
import com.java.programs.NumberToWords;

/**
 * Unit test for NumberToWords.
 */
public class NumberToWordsTest implements Constants
{
	INumberToWords numberToWords = new NumberToWords();
	String numberInWord = null;
	
    @Test
    public void testZero()
    {
		try {
			numberInWord = numberToWords.convert(0);
		} catch (Exception e) {
			e.printStackTrace();
			fail(NO_EXCEPTION);
		}
    	assertNotNull(numberInWord);
    	assertEquals("Expected zero but got "+numberInWord, "zero", numberInWord);
    }
    
    @Test
    public void testOne()
    {
		try {
			numberInWord = numberToWords.convert(1);
		} catch (Exception e) {
			e.printStackTrace();
			fail(NO_EXCEPTION);
		}
    	assertNotNull(numberInWord);
    	assertEquals("one", numberInWord);
    }
    
    @Test
    public void testNumberInTens()
    {
		try {
			numberInWord = numberToWords.convert(16);
		} catch (Exception e) {
			e.printStackTrace();
			fail(NO_EXCEPTION);
		}
    	assertNotNull(numberInWord);
    	assertEquals("sixteen", numberInWord);
    }
    
    @Test
    public void testEdgeNumberInHundreds()
    {
		try {
			numberInWord = numberToWords.convert(100);
		} catch (Exception e) {
			e.printStackTrace();
			fail(NO_EXCEPTION);
		}
    	assertNotNull(numberInWord);
    	assertEquals("one hundred", numberInWord);
    }
    
    @Test
    public void testNumberInHundreds()
    {
		try {
			numberInWord = numberToWords.convert(116);
		} catch (Exception e) {
			e.printStackTrace();
			fail(NO_EXCEPTION);
		}
    	assertNotNull(numberInWord);
    	assertEquals("one hundred and sixteen", numberInWord);
    }
    
    @Test
    public void testNumberInThousands()
    {
		try {
			numberInWord = numberToWords.convert(1316);
		} catch (Exception e) {
			e.printStackTrace();
			fail(NO_EXCEPTION);
		}
    	assertNotNull(numberInWord);
    	assertEquals("one thousand three hundred and sixteen", numberInWord);
    }
    
    @Test
    public void testNumberInTenThousands()
    {
		try {
			numberInWord = numberToWords.convert(10501);
		} catch (Exception e) {
			e.printStackTrace();
			fail(NO_EXCEPTION);
		}
    	assertNotNull(numberInWord);
    	assertEquals("ten thousand five hundred and one", numberInWord);
    }
    
    @Test
    public void testNumberInHundredThousand()
    {
		try {
			numberInWord = numberToWords.convert(100509);
		} catch (Exception e) {
			e.printStackTrace();
			fail(NO_EXCEPTION);
		}
    	assertNotNull(numberInWord);
    	assertEquals("one hundred and thousand five hundred and nine", numberInWord);
    }
    
    @Test
    public void testNumberInMillion()
    {
		try {
			numberInWord = numberToWords.convert(1005004);
		} catch (Exception e) {
			e.printStackTrace();
			fail(NO_EXCEPTION);
		}
    	assertNotNull(numberInWord);
    	assertEquals("one million five thousand four", numberInWord);
    }
    
    @Test
    public void testNumberInTensMillion()
    {
		try {
			numberInWord = numberToWords.convert(99899899);
		} catch (Exception e) {
			e.printStackTrace();
			fail(NO_EXCEPTION);
		}
    	assertNotNull(numberInWord);
    	assertEquals("ninety nine million eight hundred and ninety nine thousand eight hundred and ninety nine", numberInWord);
    }
    
    @Test
    public void testNumberInHundredMillion()
    {
		try {
			numberInWord = numberToWords.convert(999999999);
		} catch (Exception e) {
			e.printStackTrace();
			fail(NO_EXCEPTION);
		}
    	assertNotNull(numberInWord);
    	assertEquals("nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine", numberInWord);
    }
    
    @Test
    public void testNegativeNumberInHundredMillion()
    {
		try {
			numberInWord = numberToWords.convert(-999999999);
		} catch (Exception e) {
			e.printStackTrace();
			fail(NO_EXCEPTION);
		}
    	assertNotNull(numberInWord);
    	assertEquals("negative nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine", numberInWord);
    }
    
    @Test
    public void testErrorNumberGreaterThanRange()
    {
		try {
			numberInWord = numberToWords.convert(1000000000);
			fail(EXCEPTION_SHOULD_OCCUR);
		} catch (Exception e) {
			assertEquals(EXCEEDED_SUPPORTED_NUM_RANGE_EXCEPTION, e.getMessage());
		}
    }
    
    @Test
    public void testErrorNegativeNumberLesserThanRange()
    {
		try {
			numberInWord = numberToWords.convert(-1000000000);
			fail(EXCEPTION_SHOULD_OCCUR);
		} catch (Exception e) {
			assertEquals(EXCEEDED_NEGATIVE_SUPPORTED_NUM_RANGE_EXCEPTION, e.getMessage());
		}
    }
    
    @Test
    public void testErrorNumberGreaterThanRangePreconditions()
    {
		try {
			numberToWords.checkPreConditions(1000000000);
			fail(EXCEPTION_SHOULD_OCCUR);
		} catch (Exception e) {
			assertEquals(EXCEEDED_SUPPORTED_NUM_RANGE_EXCEPTION, e.getMessage());
		}
    }
    
    @Test
    public void testErrorNegativeNumberLesserThanRangePreconditions()
    {
		try {
			numberToWords.checkPreConditions(-1000000000);
			fail(EXCEPTION_SHOULD_OCCUR);
		} catch (Exception e) {
			assertEquals(EXCEEDED_NEGATIVE_SUPPORTED_NUM_RANGE_EXCEPTION, e.getMessage());
		}
    }
    
    @Test
    public void testNumberLessThanThousand()
    {
    	String numberInWord = numberToWords.convertLessThanOneThousand(999);
    	assertNotNull(numberInWord);
    	assertEquals("nine hundred and ninety nine", numberInWord.trim());
    }
}
