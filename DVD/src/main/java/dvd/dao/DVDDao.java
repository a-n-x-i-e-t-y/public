/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dvd.dao;

import dvd.dto.DVDObj;
import java.util.Set;

/**
 *
 * @author mikeh
 */
public interface DVDDao {

    DVDObj addDVD(String title, DVDObj dvd);

    DVDObj removeDVD(String title);
    
    DVDObj editDVD (String title, DVDObj dvd);
    
    Set<String> getAllDVDNames();

    DVDObj getDVDAtt(String title);
    
    DVDObj searchDVD (String title);
    
    void loadLibrary();
    
    void saveLibrary();
    
    //DvdObj editMultiple();
    
    
    
}

