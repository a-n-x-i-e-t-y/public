package studentquizscores.dto;

import java.util.ArrayList;

/**
 *
 * @author Grant
 */
public class Student {
    private String firstName;
    private String lastName;
    private String studentId;
    private ArrayList<Double> scores = new ArrayList<>();

    public Student(String studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentId() {
        return studentId;
    }

    public ArrayList<Double> getAllScores() {
        return scores;
    }
    
    public double getAverageScores(){
        double ave = 0;
        for(double vals : scores){
            ave += vals;
        }
        return ave / scores.size();
    }

    public void addScores(double score) {
        this.scores.add(score);
    }
    
}
