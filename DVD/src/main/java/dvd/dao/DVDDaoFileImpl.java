/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dvd.dao;

import dvd.dto.DVDObj;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author mikeh
 */
public class DVDDaoFileImpl implements DVDDao {

    private Map<String, DVDObj> dvdCollection = new HashMap<>();

    @Override
    public DVDObj addDVD(String title, DVDObj dvd) {
        DVDObj tempdvd = dvdCollection.put(title, dvd);
        return tempdvd;
    }

    @Override
    public DVDObj removeDVD(String title) {
        DVDObj tempdvd = dvdCollection.get(title);
        dvdCollection.remove(title);
        return tempdvd;
    }

    @Override
    public DVDObj editDVD(String title, DVDObj dvd) {

        dvdCollection.put(title, dvd);

        DVDObj tempdvd = dvdCollection.get(title);

        return tempdvd;

    }

    @Override
    public Set<String> getAllDVDNames() {
        Set<String> dvdtitles = dvdCollection.keySet();
        return dvdtitles;

    }

    @Override
    public DVDObj getDVDAtt(String title) {

        DVDObj tempdvd = dvdCollection.get(title);

        return tempdvd;
    }

    @Override
    public DVDObj searchDVD(String title) {
        DVDObj tempdvd = dvdCollection.get(title);

        return tempdvd;

    }

    @Override
    public void loadLibrary() {
        try {

            File f = new File("collection.txt");
            if (!f.exists()) {
                System.out.println("File doesn't exist");
                throw new Exception();
            }

            Scanner sc = new Scanner(new BufferedReader(new FileReader("collection.txt")));//to read from file

            while (sc.hasNextLine()) {

                String currentLine = sc.nextLine();
                String[] storeState = currentLine.split("::", 0);

                //Revert any empty strings which may have been stored as spaces
                for (String value : storeState){
                    value = revertEmptyValue(value);
                }
                
                DVDObj tempdvd = new DVDObj();
                tempdvd.setTitle(storeState[0]);
                tempdvd.setReleaseDate(storeState[1]);
                tempdvd.setRating(storeState[2]);
                tempdvd.setDirectors(storeState[3]);
                tempdvd.setStudio(storeState[4]);
                tempdvd.setNote(storeState[5]);

                dvdCollection.put(storeState[0], tempdvd);

            }

        } catch (Exception e) {
            System.out.println("YOu got an erreor " + e.getMessage());
        }
    }

    //creates a file if it does not exist. otherwise populates a string with object parameters and
    //saves it to a file line by line.
    @Override
    public void saveLibrary() {

        try {//to create file
            File myObj = new File("collection.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {//to write to file
            FileWriter myWriter = new FileWriter("collection.txt");


            for (Map.Entry<String, DVDObj> entry : dvdCollection.entrySet()) { // iterates through keys in hashmap
                DVDObj tempdvd = entry.getValue();
                myWriter.write(tempdvd.getTitle() + "::" 
                        + correctEmptyString(tempdvd.getReleaseDate()) + "::" 
                        + correctEmptyString(tempdvd.getRating()) + "::" 
                        + correctEmptyString(tempdvd.getDirectors()) + "::" 
                        + correctEmptyString(tempdvd.getStudio()) + "::" 
                        + correctEmptyString(tempdvd.getNote()) + "\n");
            }

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    /**
     * Small function to check if a string (particularly an object value)
     * is empty. If the string is empty, it returns a single space to correct to prevent
     * empty strings from being written to a file which can corrupt delimitation.
     */
    public String correctEmptyString(String checkString) {
        if (checkString.equals("")) {
            return " ";
        }
        return checkString;
    }
    
    /**
     * Returns any single space values to their original empty string value
     * Primarily used when loading data from a file in which a object value
     * was adjusted to a single space to preserve delimitation.
     */
    public String revertEmptyValue(String checkString) {
        if (checkString.equals(" ")) {
            return "";
        }
        return checkString;
    }

}
