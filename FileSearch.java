////////////////////////////////
//
//   Ethan-John Rasmussen
//   Assignment 10
//   12/6/2017
//
////////////////////////////////
////////////////////////////////////////////////////////////////
//
//   DESCRIPTION: This program recursively searches for a certain file on your computer.   
//                
//                
//
//   INPUTS: Program takes in a filename and a starting folder.
//
//   OUTPUTS: String that is the pathname of the file.
//            
//
////////////////////////////////////////////////////////////////
package filesearch;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class FileSearch {
    /*****************************************************************
    *
    * Name: searchForFile(File, String)
    * Description: This method takes the starting file and the filename it is looking for and then 
    *              Recursively finds it by searching through folders.
    * Inputs: One File and one String
    * Output: String that denotes the pathname of the file. 
    * Preconditions: None
    *
    *
    *
     * @return String
    *****************************************************************/
    public static String searchForFile(File currentFolder, String fileName) {
        // Used for debugging
        System.out.println("Searching " + currentFolder.getName());
        
        if (currentFolder.isDirectory()) {
        
            /* Used for debugging
            if (currentFolder.listFiles() != null) {
                System.out.println(currentFolder.listFiles().length);
            }
            */
            
            // Create a File array from the listFiles method.
            File[] filesInFolder = currentFolder.listFiles();
            // Enter loop if directory is not empty.
            if (currentFolder.listFiles() != null) {
                // Loop through every file in directory
                for (File fileLoop : filesInFolder) {
                    // recursive call
                    String found = searchForFile(fileLoop, fileName);
                    // if the pathname returned contains the filename return it
                    if (found.contains(fileName)) { 
                        return found;
                    }
                }
            }
        // This code executes if the file is not a directory, will return the pathname if it is the File we are looking for
        } else if (currentFolder.getName().equals(fileName)) {
            return currentFolder.getAbsolutePath();
        }
            return "";
        }

    public static void main(String[] args) {
        // Create File at starting folder.
        File startingFolder = new File("C:\\Users\\");

        System.out.println("Searching for file.");
        // Call recursive method.
        System.out.println(searchForFile(startingFolder, "FileSearch.java"));
    }
}
