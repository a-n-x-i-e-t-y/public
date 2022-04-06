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
            Scanner sc = new Scanner(new BufferedReader(new FileReader("collection.txt")));//to read from file

            String currentLine = sc.nextLine();
            String[] storestate = currentLine.split("::", 0);

        } catch (Exception e) {

        }
    }

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
            myWriter.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

}
