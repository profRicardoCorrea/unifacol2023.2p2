package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatetimeExtensions
{
    public static Date toDate(String date) throws ParseException
    {
    	try {
    		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
        	Date data = formato.parse(date);
            return data; 
			
		} catch (Exception e) {
			System.out.println("Data Inválida: Error:"+e.getMessage());
			throw e;
		}
    	
    }
    public static String toString(Date date) throws ParseException
    {
    	try {
    		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
        	 
            return formato.format(date); 
			
		} catch (Exception e) {
			System.out.println("Data Inválida: Error:"+e.getMessage());
			throw e;
		}
    	
    }
}

