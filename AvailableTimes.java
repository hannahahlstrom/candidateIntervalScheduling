
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AvailableTimes {
	public static final LocalDateTime CURR_DATE = LocalDateTime.now();
	private HashMap<LocalDateTime, LocalDateTime> availTimes;
	
	public AvailableTimes(HashMap<LocalDateTime, LocalDateTime> availTimes) {
		this.availTimes = availTimes;
	}
	
	public HashMap<LocalDateTime, LocalDateTime> addAvailTime(String inputLine) {
		if(inputLine.charAt(0) == ' ') inputLine = inputLine.substring(1);
		String day = "" + inputLine.charAt(0);
		int daysFromSaturday = 0;
		if(day.equals("N")) {
			daysFromSaturday = 1;
		} else if(day.equals("M")) {
			daysFromSaturday = 2;
		} else if(day.equals("T")) {
			daysFromSaturday = 3;
		} else if(day.equals("W")) {
			daysFromSaturday = 4;
		} else if(day.equals("R")) {
			daysFromSaturday = 5;
		} else if(day.equals("F")) {
			daysFromSaturday = 6;
		} else {
			daysFromSaturday = 7;
		} 

		String startTime = inputLine.substring(1,inputLine.indexOf("-"));
		String startTimeHour = startTime.substring(0, startTime.indexOf(":"));
		String startTimeMin = startTime.substring(startTime.indexOf(":")+1);;
		
		String endTime = inputLine.substring(inputLine.indexOf("-")+1);
		String endTimeHour = endTime.substring(0, endTime.indexOf(":"));
		String endTimeMin = endTime.substring(endTime.indexOf(":")+1);;
		
		LocalDateTime dateStartTime = LocalDateTime.of(CURR_DATE.getYear(), CURR_DATE.getMonthValue(),
				CURR_DATE.getDayOfMonth() + daysFromSaturday, Integer.parseInt(startTimeHour), Integer.parseInt(startTimeMin), 0);	
		LocalDateTime dateEndTime = LocalDateTime.of(CURR_DATE.getYear(), CURR_DATE.getMonthValue(),
				CURR_DATE.getDayOfMonth() + daysFromSaturday, Integer.parseInt(endTimeHour), Integer.parseInt(endTimeMin), 0);
		this.availTimes.put(dateStartTime, dateEndTime);
		return this.availTimes; 
	}
	
	// main method used for testing purposes only
	public static void main(String[] args) {
		 HashMap<LocalDateTime, LocalDateTime> availTimes = new HashMap<>();
		AvailableTimes testList = new AvailableTimes(availTimes);
		availTimes = testList.addAvailTime("M10:00-13:15");	
		System.out.print(availTimes.toString());
	}
}


