package com.vipin.algorithm.hashing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexValidation {

	public static boolean validateJavaScriptRegex(String input, String jsRegexPattern) {
		try {
			// Escape forward slashes in JavaScript regex pattern
			String escapedPattern = jsRegexPattern.replace("/", "\\/");

			// Compile the pattern
			Pattern pattern = Pattern.compile(escapedPattern);

			// Create a matcher with the input string
			Matcher matcher = pattern.matcher(input);

			// Check if the input matches the pattern
			return matcher.matches();
		} catch (Exception e) {
			// Handle exceptions, e.g., if the regex pattern is invalid
			return false;
		}
	}

	public static void main(String[] args) {
		String input1 = "example123";
		String jsRegexPattern = "^.*[a-zA-Z]+.*$";
		String jsRegexPattern1 = "^[a-zA-Z0-9*$";
		
		Pattern.compile(jsRegexPattern);
		try {
		Pattern.compile(jsRegexPattern1);
		}catch(Exception ex) {
			System.out.println("Inavlid pattern");
		}

		boolean isValid1 = validateJavaScriptRegex(input1, jsRegexPattern);
		String input2 = "123";
		boolean isValid2 = validateJavaScriptRegex(input2, jsRegexPattern);
		String input3 = "123abcd%";
		boolean isValid3 = validateJavaScriptRegex(input3, jsRegexPattern);
		String input4 = "#abcd%";
		boolean isValid4= validateJavaScriptRegex(input4, jsRegexPattern);
		String input5 = "#12345%";
		boolean isValid5 = validateJavaScriptRegex(input5, jsRegexPattern);
		System.out.println("1:"+isValid1 + " 2:" +isValid2 + " 3:"+isValid3 + " 4:" +isValid4 + " 5:" +isValid5);
		
		if (isValid1) {
			System.out.println("Input is valid according to JavaScript regex pattern.");
		} else {
			System.out.println("Input is not valid according to JavaScript regex pattern.");
		}
		
		
		String jsRegex = "/^(\\(\\d{3}\\)\\d{3}-\\d{4}|\\(\\d{3}\\)\\d{7}|\\d{10})$/";
		Pattern.compile(jsRegex);
		System.out.println(jsRegex);
		String input6 = "123";
		boolean isValid6 = validateJavaScriptRegex(input6, jsRegexPattern);
		String input7 = "123";
		boolean isValid7 = validateJavaScriptRegex(input7, jsRegexPattern);
		String input8 = "123abcd%";
		boolean isValid8 = validateJavaScriptRegex(input8, jsRegexPattern);
		String input9 = "#abcd%";
		boolean isValid9= validateJavaScriptRegex(input9, jsRegexPattern);
		String input10 = "(123)1237865";
		boolean isValid10 = validateJavaScriptRegex(input10, jsRegexPattern);
		
		String input11 = "(123)123(7865)";
		boolean isValid11 = validateJavaScriptRegex(input11, jsRegexPattern);
		System.out.println("6:"+isValid6 + " 7:" +isValid7 + 
				" 8:"+isValid8 + " 9:" +isValid9 + " 10:" +isValid10 + " 11:" +isValid11);
		
		
		String jsRegex1 = "^\\d{10}$";
		Pattern.compile(jsRegex);
		System.out.println(jsRegex1);
		String input12 = "123";
		boolean isValid12 = validateJavaScriptRegex(input12, jsRegex1);
		String input13 = "1234567890";
		boolean isValid13 = validateJavaScriptRegex(input13, jsRegex1);
		String input14 = "123abcd%";
		boolean isValid14 = validateJavaScriptRegex(input14, jsRegex1);
		String input15 = "#abcd%";
		boolean isValid15= validateJavaScriptRegex(input15, jsRegex1);
		String input16 = "(123)1237865";
		boolean isValid16 = validateJavaScriptRegex(input16, jsRegex1);
		
		String input17 = "1234567890";
		boolean isValid17 = validateJavaScriptRegex(input17, jsRegex1);
		
		String jsRegex2 = "^[a-zA-Z0-9 \\,.\\-'\\/]+";
		Pattern.compile(jsRegex2);
		System.out.println(jsRegex2);
		String input20 = "123";
		boolean isValid20 = validateJavaScriptRegex(input20, jsRegex2);
		String input21 = " 22\3, 7th Block";
		boolean isValid21 = validateJavaScriptRegex(input21, jsRegex2);
		System.out.println("l20: " + isValid20 + " l21: " + isValid21);
		
		System.out.println("12:"+isValid12 + " 13:" +isValid13 + 
				" 14:"+isValid14 + " 15:" +isValid15 + " 16:" +isValid16 + " 17:" +isValid17);


		
	}

}
