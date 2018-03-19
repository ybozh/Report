package processing;

import java.util.Calendar;
import java.util.Date;

import com.toedter.calendar.JDateChooser;

public class CreateCode {
	
	public static String createCode (String code, JDateChooser dateChooser_2) {
		Calendar dateOfReport = dateChooser_2.getCalendar();
		
		int Year = dateOfReport.get(Calendar.YEAR) % 100;
		int Month = dateOfReport.get(Calendar.MONTH) + 1;
		
		String Month1;
		if (Month < 10) {
			Month1 = "0" + Month;
		} else Month1 = Integer.toString(Month);
		
		int Day = dateOfReport.get(Calendar.DAY_OF_MONTH);
		String Day1;
		if (Day < 10) {
			Day1 = "0" + Day;
		} else Day1 = Integer.toString(Day);
		
		return code + Year + Month1 + Day1;
	}

}
