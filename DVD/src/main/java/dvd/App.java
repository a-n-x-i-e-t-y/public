/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package dvd;

import DVDcollection.ui.DVDView;
import DVDcollection.ui.UserIO;
import DVDcollection.ui.UserIOConsoleImpl;
import dvd.controller.DVDController;
import dvd.dao.DVDDao;
import dvd.dao.DVDDaoFileImpl;

/**
 *
 * @author mikeh
 */
public class App {

    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        DVDView myView = new DVDView(myIo);
        DVDDao myDao = new DVDDaoFileImpl();
        DVDController controller = new DVDController(myDao, myView);
        controller.run();
    }   
}
