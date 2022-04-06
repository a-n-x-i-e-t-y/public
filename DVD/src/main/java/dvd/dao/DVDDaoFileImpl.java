/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dvd.dao;

import dvd.dto.DVDObj;
import java.util.HashMap;
import java.util.Map;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DVDObj searchDVD(String title) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DVDObj loadDVD() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DVDObj saveDVD() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
