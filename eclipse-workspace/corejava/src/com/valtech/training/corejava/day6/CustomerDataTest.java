package com.valtech.training.corejava.day6;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class CustomerDataTest {
	
	
    
    //Customer cu= new Customer();
	
	int Diamond=4;
	int Platinum =3;
	int gold=2;
	int silver=1;
	@Test
	public void test() throws Exception {
		// SimpleDateFormat df =new SimpleDateFormat("dd-MM-yyyy");
		Set<CustomerData> cust= new TreeSet<CustomerData>();
		
		CustomerData cus1= new CustomerData("Ritesh",Diamond,"2001-09-25",23000);
		CustomerData cus2= new CustomerData("Pramod",Platinum,"2001-09-13",23000);
  	    CustomerData cus3= new CustomerData("Nuthan",Diamond,"2001-08-25",5400);
        CustomerData cus4= new CustomerData("Sanjay",Platinum,"2001-09-10",54000);
        CustomerData cus5= new CustomerData("Sai",gold,"2001-10-25",5400);
        CustomerData cus6= new CustomerData("Subbu",silver,"2001-10-25",5400);
        CustomerData cus7= new CustomerData("Anuj",Diamond,"2001-09-25",54000);
        
		
		cust.add(cus1);
		cust.add(cus2);
  	    cust.add(cus3);
  	    cust.add(cus4);
  	    cust.add(cus5);
  	    cust.add(cus6);
  	    cust.add(cus7);
  	    
  	    
		
		 System.out.println(cust.size()+" Customer Data");
		for(CustomerData c : cust) {
			System.out.println(c.name+" "+convert_to_string(c.type)+" "+c.date+" "+c.moneyspent);
		}
		
//		 LocalDate currdate1= LocalDate.parse("2001-09-25");
//		   int month1= currdate1.getMonthValue();
//		   int year1=currdate1.getYear();
//		   System.out.println(month1);
//		   System.out.println(year1);
			
		
		
	}
	
	public String convert_to_string (int t1) {
		switch (t1) {
		case 1:
			  return "Silver";
		
		case 2:
			  return "Gold";
		
		case 3:
			  return "Paltinum";
			
		case 4:
			  return "Diamond";
			

		default:
			return "0";
		
		}
	}

}
