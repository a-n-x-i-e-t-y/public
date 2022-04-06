/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dvd.dao;

import dvd.dto.DVDObj;
import java.util.List;

/**
 *
 * @author mikeh
 */
public interface DVDDao {

    DVDObj addDVD(String title, DVDObj dvd);

    DVDObj removeDVD(String title);
    
    DVDObj editDVD (String title);
    
    List<DVDObj> getAllDVDObjs();

    DVDObj getDVDAtt(String title);
    
    DVDObj searchDVD (String title);
    
    DVDObj loadDVD ();
    
    DVDObj saveDVD ();
    
    //DvdObj editMultiple();
    
    
    
}

