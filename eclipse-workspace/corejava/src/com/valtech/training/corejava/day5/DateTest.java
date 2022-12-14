package com.valtech.training.corejava.day5;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;


public class DateTest {

//	@Test
//	public void testDate() {
//		Date date=new Date();
//		System.out.println(date);
//		/*
//		 * HH-Hour
//		 * mm=Minute
//		 * ss-Second
//		 * SS-MiliSeconds
//		 * YY/YYYY-Year
//		 * MM/MMM-Month
//		 * dd-Day
//		 * DD-date in 365 days
//		 */
//		DateFormat df = new SimpleDateFormat("dd-MMM-YYYY HH:mm:ss");
//		System.out.println(df.format(date));
//	}
//	@Test
//	public void testDateOldWay() {
//		Date date=new Date(47,7,15);
//		System.out.println(date);
//		DateFormat df = new SimpleDateFormat("dd-MMM-YYYY HH:mm:ss");
//		System.out.println(df.format(date));
//	}
//	@Test
//	public void testDateWithCal() {
//		Calendar cal=Calendar.getInstance();
//		cal.set(Calendar.YEAR, 1947);
//		cal.set(Calendar.MONTH, Calendar.AUGUST);
//		cal.set(Calendar.DATE, 15);
//		Date date=cal.getTime();
//		System.out.println(date);
//		DateFormat df = new SimpleDateFormat("dd-MMM-YYYY HH:mm:ss");
//		System.out.println(df.format(date));
//		
//	}
	@Test
	public void testDateFromString() throws Exception{
		SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy");
		Date date=df.parse("15-08-1947");
		System.out.println(date);
		Date date1=new Date(47,07,15);
		System.out.println(df.format(date1));
		
	}

}
