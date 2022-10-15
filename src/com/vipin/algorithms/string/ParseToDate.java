package com.vipin.algorithms.string;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class ParseToDate {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		String str_date = "11-June-07";
		DateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
		Date date = formatter.parse(str_date);
		System.out.println(date);
		String string = "January 2, 2010";
		DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
		Date date1 = format.parse(string);
		System.out.println(date1);
		
		Date outputDate = null;
        String[] possibleDateFormats =
              {
                    "yyyy.MM.dd G 'at' HH:mm:ss z",
                    "EEE, MMM d, ''yy",
                    "h:mm a",
                    "hh 'o''clock' a, zzzz",
                    "K:mm a, z",
                    "yyyyy.MMMMM.dd GGG hh:mm aaa",
                    "EEE, d MMM yyyy HH:mm:ss Z",
                    "yyMMddHHmmssZ",
                    "yyyy-MM-dd'T'HH:mm:ss.SSSZ",
                    "yyyy-MM-dd'T'HH:mm:ss.SSSXXX",
                    "YYYY-'W'ww-u",
                    "EEE, dd MMM yyyy HH:mm:ss z", 
                    "EEE, dd MMM yyyy HH:mm zzzz",
                    "yyyy-MM-dd'T'HH:mm:ssZ",
                    "yyyy-MM-dd'T'HH:mm:ss.SSSzzzz", 
                    "yyyy-MM-dd'T'HH:mm:sszzzz",
                    "yyyy-MM-dd'T'HH:mm:ss z",
                    "yyyy-MM-dd'T'HH:mm:ssz", 
                    "yyyy-MM-dd'T'HH:mm:ss",
                    "yyyy-MM-dd'T'HHmmss.SSSz",
                    "yyyy-MM-dd",
                    "yyyyMMdd",
                    "dd/MM/yy",
                    "dd/MM/yyyy"
              };

     

        String string1 = "January 2, 2010";
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        LocalDate date2= LocalDate.parse(string, formatter1);
        System.out.println(date1); // 2010-01-02
	}

	     
	    
	

}
