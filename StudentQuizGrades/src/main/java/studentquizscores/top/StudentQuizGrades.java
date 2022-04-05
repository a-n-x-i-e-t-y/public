package studentquizscores.top;

import studentquizscores.dto.Student;
import studentquizscores.ui.ClassRosterView;
import studentquizscores.ui.UserIO;
import studentquizscores.ui.UserIOConsoleImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Grant
 */
public class StudentQuizGrades {
    // Create view object
    ClassRosterView view = new ClassRosterView();

    // HashMap for Students 
    HashMap<String, Student> students = new HashMap<>();
    
    
    // Method for viewing all students
    public void viewAllStudents(){
        // Obtain student objects
        List<Student> allStudents = new ArrayList<>(students.values());
        
        // Display all students
        view.displayStudentList(allStudents);        
    }
    
    
    // Method adding a student to system (hm)
    public void addStudent(){
        // New student object
        Student newStudent = view.getNewStudentInfo();
        
        // Add to hashmap
        students.put(newStudent.getStudentId(), newStudent);
    }
    
    
    // Remove student from the system (hm)
    public void removeStudent(){
        // Get student id to remove
        String id = view.getStudentIdChoice();
        
        view.displayRemoveStudentBanner();
        
        // Display removal result
        view.displayRemoveResult(students.get(id));
        
        // Check hm for id
        if(students.get(id) != null){
            students.remove(id);   
        }
    }
    
    
    // View student data
    public void viewStudentScores(){
        // Get student id to remove
        String id = view.getStudentIdChoice();
        
        // Show student data
        view.displayStudent(students.get(id));
    }
    
    // Add score to student
    public void addScoresToStudent(){
        // Get student id to remove
        String id = view.getStudentIdChoice();
        
        // Check to see if the student exists
        view.displayStudent(students.get(id));
        
        // Loop until done entering scores
        boolean go = true;
        while(go){
            // selction variable
            int selection;
            
            // Display menu
            selection = view.menuOptions();
            
            if(selection == 1){
                // Get student object
                Student newStudent = students.get(id);
                
                // Prompt for the new score
                double score = view.addScore(newStudent);
                
                // Add the new score to the student
                newStudent.addScores(score);
            }else {go = false;}
        }
        // Display changed student scores
        view.displayStudent(students.get(id));
    }
    
    
    public static void main(String[] args) {
        boolean go = true;
        ClassRosterView view2 = new ClassRosterView();
        StudentQuizGrades runner = new StudentQuizGrades();
        UserIO io = new UserIOConsoleImpl();
        while(go){
            // Prompt the user for input
            int option = view2.printMenuAndGetSelection();
            
            switch(option){
                case 1 -> runner.viewAllStudents();
                case 2 -> runner.addStudent();
                case 3 -> runner.viewStudentScores();
                case 4 -> runner.removeStudent();
                case 5 -> runner.addScoresToStudent();
                case 6 -> go = false;
                default -> io.print("Invalid Input");
            }       
        }
        io.print("Thank you for your time");
    }
}
