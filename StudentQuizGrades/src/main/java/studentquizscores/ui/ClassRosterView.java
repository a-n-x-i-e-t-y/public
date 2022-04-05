package studentquizscores.ui;
import studentquizscores.dto.Student;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Grant
 */
public class ClassRosterView {
    private UserIO io = new UserIOConsoleImpl();

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List Students");
        io.print("2. Create New Student");
        io.print("3. View a Students Scores");
        io.print("4. Remove a Student");
        io.print("5. Add Score to Student");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }
    
    public Student getNewStudentInfo() {
        String studentId = io.readString("Please enter Student ID");
        String firstName = io.readString("Please enter First Name");
        String lastName = io.readString("Please enter Last Name");
        Double score = io.readDouble("Please enter a score for this Student");
        Student currentStudent = new Student(studentId);
        currentStudent.setFirstName(firstName);
        currentStudent.setLastName(lastName);
        currentStudent.addScores(score);
        return currentStudent;
    }
    
    public void displayCreateStudentBanner() {
        io.print("=== Create Student ===");
    }
    
    public void displayCreateSuccessBanner() {
        io.readString(
                "Student successfully created.  Please hit enter to continue");
    }
    
    public void displayStudentList(List<Student> studentList) {
        for (Student currentStudent : studentList) {
            String studentInfo = String.format("#%s : %s %s",
                    currentStudent.getStudentId(),
                    currentStudent.getFirstName(),
                    currentStudent.getLastName());
            io.print(studentInfo);
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayDisplayAllBanner() {
        io.print("=== Display All Students ===");
    }
    
    
    public void displayDisplayStudentBanner () {
        io.print("=== Display Student ===");
    }
    
    
    public String getStudentIdChoice() {
        return io.readString("Please enter the Student ID.");
    }
    
    
    public void displayStudent(Student student) {
        if (student != null) {
            io.print("Student id: " + student.getStudentId());
            io.print("Student name: " + student.getFirstName() + " " + student.getLastName());
            io.print("All Scores: " + student.getAllScores().toString());
            io.print("Average Score: " + Double.toString(student.getAverageScores()));
        } else {
            io.print("No such student.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public int menuOptions(){
        io.print("\n============================");
        io.print("Here are your options: ");
        io.print("1. Add a score ");
        io.print("2. Quit");
        int selection = io.readInt("Make your selection: ");
        return selection;
    }
    
    public double addScore(Student student){
        // Prompt for score to add
        double score = io.readDouble("Enter the score to add: ");
        return score;
    }
    
    
    public void displayRemoveStudentBanner () {
        io.print("=== Remove Student ===");
    }

    
    public void displayRemoveResult(Student studentRecord) {
        if(studentRecord != null){
            io.print("Student successfully removed.");
        }else{
            io.print("No such student.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }
    
    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
    
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
