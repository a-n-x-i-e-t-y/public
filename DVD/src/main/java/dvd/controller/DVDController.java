package dvd.controller;

import DVDcollection.ui.DVDView;
import DVDcollection.ui.UserIO;
import DVDcollection.ui.UserIOConsoleImpl;
import dvd.dao.DVDDao;
import dvd.dto.DVDObj;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
public class DVDController {

    private DVDDao dao;
    private DVDView view;
    int menuSelection = 0;

    public DVDController(DVDDao dao, DVDView view) {
        this.dao = dao;
        this.view = view;
    }

    
    public void run() {
        boolean keepGoing = true;
        while (keepGoing) {

            menuSelection = view.printMenuAndGetSelection();

            switch (menuSelection) {
                case 1 -> addDvd();
                case 2 -> removeDvd();
                case 3 -> editDvd();
                case 4 -> displayCollectionList();
                case 5 -> displayDVD();
                case 6 -> searchDVD();
                case 7 -> loadDVD();
                case 8 -> saveDVD();
                case 9 -> keepGoing = false;
            }

        }
        
        view.displayExitBanner();
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
                case 1 -> tempDvd.setReleaseDate(view.getProperty());
                case 2 -> tempDvd.setRating(view.getProperty());
                case 3 -> tempDvd.setDirectors(view.getProperty());
                case 4 -> tempDvd.setStudio(view.getProperty());
                case 5 -> tempDvd.setNote(view.getProperty());
            }
            view.displaySuccessBanner(menuSelection);
        } else {
            view.displayNoDvdError(title);
        }

    }

    private void displayCollectionList() {
        view.displaySelectionBanner(menuSelection);
        List<String> collection = new ArrayList<>(dao.getAllDVDNames());
        view.displayDvdList(collection);
        view.displaySuccessBanner(menuSelection);
    }

    private void displayDVD() {
        view.displaySelectionBanner(menuSelection);
        String title = view.getTitle();
        DVDObj tempDvd = dao.getDVDAtt(title);

        if (tempDvd != null) {
            view.displayDvdInfo(tempDvd);
            view.displaySuccessBanner(menuSelection);
        } else {
            view.displayNoDvdError(title);
        }
    }

    private void searchDVD() {
        view.displaySelectionBanner(menuSelection);
        String search = view.getQuery();
        List<String> names = new ArrayList<>(dao.getAllDVDNames());
        view.displaySearchResults(names, search);
        view.displaySuccessBanner(menuSelection);
    }

    private void loadDVD() {
        view.displaySelectionBanner(menuSelection);
        dao.loadLibrary();
        view.displaySuccessBanner(menuSelection);

    }

    private void saveDVD() {
        view.displaySelectionBanner(menuSelection);
        dao.saveLibrary();
        view.displaySuccessBanner(menuSelection);
    }

}
