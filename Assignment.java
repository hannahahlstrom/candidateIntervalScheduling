import java.time.LocalDateTime

public class Assignment {
	  private String title;
	  private String type;
	  private int classNum;
	  private double weight;
	  private LocalDateTime dueDate;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getClassNum() {
		return classNum;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public LocalDateTime getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}
	/**
	 * @param title
	 * @param type
	 * @param classNum
	 * @param weight
	 * @param dueDate
	 */
	public Assignment(String title, String type, int classNum, double weight, LocalDateTime dueDate) {
		this.title = title;
		this.type = type;
		this.classNum = classNum;
		this.weight = weight;
		this.dueDate = dueDate;
	}

}
