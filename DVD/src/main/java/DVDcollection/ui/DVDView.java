package DVDcollection.ui;

import dvd.dto.DVDObj;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
public class DVDView {

    private UserIO io;

    public int printMenuAndGetSelection() {
        io.print("=======Main Menu========");
        io.print("1. Add a DVD");
        io.print("2. Remove a DVD");
        io.print("3. Edit existing DVD");
        io.print("4. List all DVDs");
        io.print("5. Display chosen DVD");
        io.print("6. Search for a DVD");
        io.print("7. Load a DVD library");
        io.print("8. Save DVD library");
        io.print("9. Exit");

        return io.readInt("Please select from the above choices.", 1, 9);
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
    public String getQuery(){
        return io.readString("Please enter your DVD title search.");
    }
    
    public String getProperty(){
        return io.readString("Please enter the updated value.");
    }
    
    public void displayNoDvdError(String title){
        io.readString("!!!The DVD <" + title + "> does not exist in"
                + " this library!!! Please hit enter to continue.");
    }
    
    public void displayDvdInfo(DVDObj dvd){
            io.print("");
            io.print("Title         : " + dvd.getTitle());
            io.print("Release Date  : " + dvd.getReleaseDate());
            io.print("Rating        : " + dvd.getRating());
            io.print("Director      : " + dvd.getDirectors());
            io.print("Studio        : " + dvd.getStudio());
            io.print("User Notes    : " + dvd.getNote());
            io.print("");
    }
    
    public void displaySearchResults(List<String> names, String search){
        List<String> searchResults = new ArrayList<>();
        for (String name : names){
            if (name.contains(search)){
                searchResults.add(name);
            }
        }
        
        if (searchResults.isEmpty()){

            io.print("\nNo results for <" + search + "> found.");
        }
        else{
            io.print("\nHere are the results matching your query <" + search +">:");
            for (String result : searchResults) io.print("-" + result);
        }
        io.print("");
    }
    
    public void displayDvdList(List<String> dvdTitles) {
        for (String title : dvdTitles) {
            io.print("-" + title);
        }
    }
    
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }
    
    public DVDView(UserIO io) {
        this.io = io;
    }
}
