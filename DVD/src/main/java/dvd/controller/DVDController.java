package dvd.controller;

import DVDcollection.ui.DVDView;
import DVDcollection.ui.UserIO;
import DVDcollection.ui.UserIOConsoleImpl;
import dvd.dao.DVDDaoFileImpl;
import dvd.dto.DVDObj;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
public class DVDController {

    private UserIO io = new UserIOConsoleImpl();
    private DVDDaoFileImpl dao = new DVDDaoFileImpl();
    private DVDView view = new DVDView(io);

    
    public void run() {
        boolean keepGoing = true;
        int menuSelection = view.printMenuAndGetSelection();
        while (keepGoing) {
            
            switch (menuSelection) {
                case 1:
                    io.print("ADD DVD");
                    addDvd();
                    break;
                case 2:
                    io.print("REMOVE DVD");
                    removeDvd();
                    break;
                case 3:
                    io.print("EDIT DVD");
                    break;
                case 4:
                    io.print("LIST DVD");
                    listCollection();
                    break;
                case 5:
                    io.print("Display DVD");
                    displayDVD();
                    break;
                case 6:
                    io.print("Search DVD");
                    searchDVD();
                    break;
                case 7:
                    loadDVD();
                    break;
                case 8:
                    io.print("Save DVD");
                    saveDVD();
                    break;
                case 9:
                    io.print("PLACEHOLDER");
                    break;
                case 10:
                    keepGoing = false;
                    break;
                default:
                    io.print("UNKNOWN COMMAND");
            }

        }
        io.print("GOOD BYE");
    }

    private void addDvd() {
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

        dao.addDVD(title, newDvd);
    }
    
    
    //methods begin here

    private void removeDvd() {
        String title = io.readString("Please enter DVD title");
        dao.removeDVD(title);
    }

    private void listCollection() {
        List<String> collection = new ArrayList<>();
        collection.addAll(dao.getAllDVDNames());
        System.out.println(collection);
    }

    private void displayDVD() {

        String title = io.readString("Please enter DVD title");
        DVDObj tempDvd = dao.getDVDAtt(title);
        
        if (tempDvd != null) {
            io.print("");
            io.print("Title: " + tempDvd.getTitle());
            io.print("Release Date: " + tempDvd.getReleaseDate());
            io.print("Rating: " + tempDvd.getRating());
            io.print("Director: " + tempDvd.getDirectors());
            io.print("Studio: " + tempDvd.getStudio());
            io.print("User Notes: " + tempDvd.getNote());
            io.print("");
        } else {
            io.print("That DVD doesnt exist.");
        }

    }

    private void searchDVD() {
        String title = io.readString("Please enter DVD title");
        
        if (dao.getAllDVDNames().contains(title)) {
            io.print("we have " + title);
        } else {
            io.print("We dont have that dvd.");
        }
        io.readString("Please hit enter to continue.");
    }
//    private void searchDVD(String title) {
//
//        if (getAllDVDNames().contains(title)) {
//            io.print("we have " + title);
//        } else {
//            io.print("We dont have that dvd.");
//        }
//        io.readString("Please hit enter to continue.");
//    }

    private void loadDVD() {
        io.print("You will load the collection from the file");
        dao.loadLibrary();
        
    }

    private void saveDVD() {
        io.print("You saved the collection to a text file");
        dao.saveLibrary();
    }

}
