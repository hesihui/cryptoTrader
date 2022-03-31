package cryptoTrader.utils;
import java.text.DateFormatSymbols;

public class DateConverter {

	public DateConverter() {
		// TODO Auto-generated constructor stub
		
	}
	public static String convertDate(String date)
	{
		String date2 = null;
		String[] arrOfStr = date.split("-", 3);
		
		String month = getMonth(Integer.parseInt(arrOfStr[1]));
	
		arrOfStr[1] = month;
		date2 = arrOfStr[0] + "-" +  arrOfStr[1] +"-"+ arrOfStr[2];
		return date2;
		
	}
	public static String getMonth(int month) {
	    return new DateFormatSymbols().getMonths()[month-1];
	}

}
