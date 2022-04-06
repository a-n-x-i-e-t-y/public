package dvd.controller;

import DVDcollection.ui.UserIO;
import DVDcollection.ui.UserIOConsoleImpl;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
public class DVDController {

    private UserIO io = new UserIOConsoleImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {

            io.print("Main Menu");
            io.print("1. Add a DVD");
            io.print("2. Remove a DVD");
            io.print("3. Edit existing DVD");
            io.print("4. List all DVDs");
            io.print("5. Display chosen DVD");
            io.print("6. Search for a DVD");
            io.print("7. Load a DVD");
            io.print("8. Save DVD library");
            io.print("9. Edit multiple DVDS");
            io.print("10. Exit");

            menuSelection = io.readInt("Please select from the"
                    + " above choices.");

            switch (menuSelection) {
                case 1:
                    io.print("ADD DVD");
                    break;
                case 2:
                    io.print("REMOVE DVD");
                    break;
                case 3:
                    io.print("EDIT DVD");
                    break;
                case 4:
                    io.print("LIST DVD");
                    break;
                case 5:
                    io.print("DISPLAY DVD");
                    break;
                case 6:
                    io.print("SEARCH DVD");
                    break;
                case 7:
                    io.print("LOAD DVD");
                    break;
                case 8:
                    io.print("SAVE DVD");
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
}
