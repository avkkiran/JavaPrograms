package com.java.programs;

public interface INumberToWords {
	public String convertLessThanOneThousand(int number);
	public String convert(int number) throws Exception;
	public void checkPreConditions(int number) throws Exception;
}
