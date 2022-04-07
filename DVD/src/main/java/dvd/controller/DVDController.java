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
    int menuSelection = 0;

    public void run() {
        boolean keepGoing = true;
        while (keepGoing) {

            menuSelection = view.printMenuAndGetSelection();

            switch (menuSelection) {
                case 1 -> addDvd();
                case 2 -> removeDvd();
                case 3 -> editDvd();
                case 4 -> listCollection();
                case 5 -> displayDVD();
                case 6 -> searchDVD();
                case 7 -> loadDVD();
                case 8 -> saveDVD();
                case 9 -> keepGoing = false;
            }

        }
        io.print("GOOD BYE");
    }

    private void addDvd() {
        view.displaySelectionBanner(menuSelection);
        DVDObj newDvd = view.getNewDvdInfo();
        dao.addDVD(newDvd.getTitle(), newDvd);
        view.displaySuccessBanner(menuSelection);
    }

    private void removeDvd() {
        view.displaySelectionBanner(menuSelection);
        String title = view.getTitle();
        dao.removeDVD(title);
        view.displaySuccessBanner(menuSelection);
    }

    private void editDvd() {
        view.displaySelectionBanner(menuSelection);
        String title = view.getTitle();
        DVDObj tempDvd = dao.getDVDAtt(title);

        if (tempDvd != null) {
            switch (view.printEditablesAndGetSelection()) {
                case 1 ->
                    tempDvd.setReleaseDate(view.getProperty());
                case 2 ->
                    tempDvd.setRating(view.getProperty());
                case 3 ->
                    tempDvd.setDirectors(view.getProperty());
                case 4 ->
                    tempDvd.setStudio(view.getProperty());
                case 5 ->
                    tempDvd.setNote(view.getProperty());
            }
            view.displaySuccessBanner(menuSelection);
        } else {
            view.displayNoDvdError(title);
        }

    }

    private void listCollection() {
        view.displaySelectionBanner(menuSelection);
        List<String> collection = new ArrayList<>();
        collection.addAll(dao.getAllDVDNames());
        System.out.println(collection);
        view.displaySuccessBanner(menuSelection);
    }

    private void displayDVD() {
        view.displaySelectionBanner(menuSelection);
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
        view.displaySuccessBanner(menuSelection);
    }

    private void searchDVD() {
        view.displaySelectionBanner(menuSelection);
        String title = io.readString("Please enter DVD title");

        if (dao.getAllDVDNames().contains(title)) {
            io.print("we have " + title);
        } else {
            io.print("We dont have that dvd.");
        }
        view.displaySuccessBanner(menuSelection);
    }

    private void loadDVD() {
        view.displaySelectionBanner(menuSelection);
        io.print("You will load the collection from the file");
        dao.loadLibrary();
        view.displaySuccessBanner(menuSelection);

    }

    private void saveDVD() {
        view.displaySelectionBanner(menuSelection);
        io.print("You saved the collection to a text file");
        dao.saveLibrary();
        view.displaySuccessBanner(menuSelection);
    }

}
