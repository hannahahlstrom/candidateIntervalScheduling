package candidateIntervalScheduling;
import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDateTime;
import java.time.Duration;


public class Calendar {
private ArrayList<Assignment> assignmentTime = new ArrayList<Assignment>();
private AvailableTimes timeAvail;
private HashMap<ArrayList<Assignment>, AvailableTimes> scheduleTime = new HashMap<>();


public HashMap<ArrayList<Assignment>, AvailableTimes> scheduleMap(ArrayList<Assignment> assignment, AvailableTimes avail) {
	assignmentTime = priorityMap(assignment);
	timeAvail = avail;
	HashMap<LocalDateTime, LocalDateTime> times = timeAvail.getAvailTimes();
	
	for (LocalDateTime key : times.keySet()) {
		int i = 0;
	    LocalDateTime list = times.get(key);
	    Duration dt = Duration.between(key, list);
	    if(assignmentTime.get(i).getDuration().compareTo(dt) > 0) {
	    	scheduleTime.put(assignmentTime, avail);
	    }
	    else
	    	continue;
	    i++;
	}
	
	return scheduleTime;
}

public ArrayList<Assignment> priorityMap(ArrayList<Assignment> a) {
	quickSort(a, 0, a.size());
	
	for (Assignment i : a) {
		i.getPriority();
	}
	
	return a;
}

private static void swap(ArrayList<Assignment> a, int i, int j) {
	Assignment temp = a.get(i);
	a.set(i, a.get(j));
	a.set(j, temp);
}

private static int partition(ArrayList<Assignment> a, int low, int high) {
	double pivot = a.get(high).getPriority();
	int i = low - 1;
	for (int j = low; j <= high - 1; j++) {
		if(a.get(j).getPriority() < pivot) {
			i++;
			swap(a, i, j);
		}
	}
	swap(a, i+1, high);
	return i;
}

private static void quickSort(ArrayList<Assignment> a, int low, int high) {
	if(low < high) {
		int pi = partition(a, low, high);
		quickSort(a, low, pi-1);
		quickSort(a, pi+1,high);
	}
	
}

}
