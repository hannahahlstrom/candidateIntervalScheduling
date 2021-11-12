package candidateIntervalScheduling;
import java.util.ArrayList;

public class Student {
private ArrayList<Assignment> workLoad = new ArrayList<Assignment>();

private ArrayList<Integer> classPriority = new ArrayList<Integer>();

private int[] workPriority = new int[4];

public ArrayList<Integer> getClassPriority() {
	return classPriority;
}

public void setClassPriority(ArrayList<Integer> classPriority) {
	this.classPriority = classPriority;
}

public int[] getWorkPriority() {
	return workPriority;
}

public void setWorkPriority(int[] workPriority) {
	this.workPriority = workPriority;
}

public ArrayList<Assignment> getWorkLoad() {
	return workLoad;
}

public String getWorkString() {
	return workLoad.toString();
}

public void setWorkLoad(ArrayList<Assignment> workLoad) {
	this.workLoad = workLoad;
}



public String toString() {
	String print = null;
	for (int i  = 0; i < workLoad.size(); i++) {
		Assignment a = workLoad.get(i);
		print = a.getTitle()+ "," + a.getType()+ "," +a.getClassNum()+ "," +a.getWeight()+ "," +a.getDueDate();
	}
	return print;
	
}


}
