import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // temp arrays to store info
        ArrayList<String> homework = new ArrayList<>();
        ArrayList<String> classes = new ArrayList<>();
        String[] priority;
        
        HashMap<LocalDateTime, LocalDateTime> availTimes = new HashMap<>();
        AvailableTimes avalT = new AvailableTimes(availTimes);

        File inputFile = new File("input.txt");
        Scanner reader = new Scanner(inputFile);
        int blanks = 0;
        while (reader.hasNextLine() && blanks < 4) {
            String line = reader.nextLine();
            if (line.isEmpty())
                blanks++;
            if (!line.startsWith("//") && !line.isEmpty()) {
                switch (blanks) {
                case 0:
                    String[] homeworkInput = line.split(",");
                    homework.add(homeworkInput[0].concat(homeworkInput[1]
                            .concat(homeworkInput[2].concat(homeworkInput[3].concat(homeworkInput[4])))));
                    break;
                case 1:
                    String[] classInput = line.split(",");
                    classes.add(classInput[0].concat(classInput[1]));
                    break;
                case 2:
                    priority = line.split(",");
                    break;
                case 3:
                    String[] avalInput = line.split(",");
                    for (String time : avalInput) {
                        avalT.addAvailTime(time);
                    }
                    break;
                default:
                    break;
                }
            }
        }
        reader.close();
    }
}
