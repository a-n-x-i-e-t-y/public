package DVDcollection.ui;

import dvd.dto.DVDObj;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
public class DVDView {

    private UserIO io;

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Add a DVD");
        io.print("2. Remove a DVD");
        io.print("3. Edit existing DVD");
        io.print("4. List all DVDs");
        io.print("5. Display chosen DVD");
        io.print("6. Search for a DVD");
        io.print("7. Load a DVD library");
        io.print("8. Save DVD library");
        io.print("9. Edit multiple DVDS");
        io.print("10. Exit");

        return io.readInt("Please select from the above choices.", 1, 10);
    }

    public DVDObj getNewDvdInfo() {
        String title = io.readString("Please enter DVD title");
        String releaseDate = io.readString("Please enter DVD release date");
        String rating = io.readString("Please enter rating");
        String directors = io.readString("Please enter director");
        String studio = io.readString("Please enter studio");
        String comment = io.readString("Please enter a commnet");

        DVDObj newDvd = new DVDObj();

        newDvd.setTitle(title);
        newDvd.setReleaseDate(releaseDate);
        newDvd.setRating(rating);
        newDvd.setDirectors(directors);
        newDvd.setStudio(studio);
        newDvd.setNote(comment);

        return newDvd;
    }

    public void displaySelectionBanner(int selection) {

        switch (selection) {
            case 1 -> io.print("==========Add DVD to Library==========");
            case 2 -> io.print("========Remove DVD from Library=======");
            case 3 -> io.print("==========Edit Existing DVD===========");
            case 4 -> io.print("=======List all DVDs in Library=======");
            case 5 -> io.print("===========Display DVD Info===========");
            case 6 -> io.print("========Search for DVD by Title=======");
            case 7 -> io.print("======Load DVD Library From Disk======");
            case 8 -> io.print("=====Save Current Library to Disk=====");
        }

    }
    public void displaySuccessBanner(int selection) {

        switch (selection) {
            case 1 -> io.readString("#DVD added to library. Please hit enter to continue#");
            case 2 -> io.readString("#DVD removed from library. Please hit enter to continue#");
            case 3 -> io.readString("#DVD info updated. Please hit enter to continue#");
            case 4 -> io.readString("#DVD collection displayed. Please hit enter to continue#");
            case 5 -> io.readString("#DVD information displayed. Please hit enter to continue#");
            case 6 -> io.readString("#Search complete. Please hit enter to continue#");
            case 7 -> io.readString("#DVD library loaded. Please hit enter to continue#");
            case 8 -> io.readString("#DVD library saved. Please hit enter to continue#");
        }

    }
    
    public int printEditablesAndGetSelection(){
        io.print("1. Edit Release Date");
        io.print("2. Edit Rating");
        io.print("3. Edit Director(s)");
        io.print("4. Edit Studio");
        io.print("5. Edit Notes/Comments");
        return io.readInt("Please select from the above choices.", 1, 5);
    }

    public String getTitle(){
        return io.readString("Please enter the DVD title.");
    }
    
    public String getProperty(){
        return io.readString("Please enter the updated value.");
    }
    
    public void displayNoDvdError(String title){
        io.readString("!!!The DVD <" + title + "> does not exist in"
                + " this library!!! Please hit enter to continue.");
    }
    /*
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

    public void displayDisplayStudentBanner() {
        io.print("=== Display Student ===");
    }

    public String getStudentIdChoice() {
        return io.readString("Please enter the Student ID.");
    }

    public void displayStudent(Student student) {
        if (student != null) {
            io.print(student.getStudentId());
            io.print(student.getFirstName() + " " + student.getLastName());
            io.print(student.getCohort());
            io.print("");
        } else {
            io.print("No such student.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveStudentBanner() {
        io.print("=== Remove Student ===");
    }

    public void displayRemoveResult(Student studentRecord) {
        if (studentRecord != null) {
            io.print("Student successfully removed.");
        } else {
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
     */
    public DVDView(UserIO io) {
        this.io = io;
    }
}
