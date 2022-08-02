package Service;

import java.io.File;

import Index.directorys;


public class Screendirectory {

    private static directorys fileDirectory = new directorys();
    
    public static void PrintFiles() {
    	
    	fileDirectory.fillFiles();

        for (File file : Screendirectory.getFileDirectory().getFiles())
        {
            System.out.println(file.getName());
        }
    }
    /**
     * @return
     */
    public static directorys getFileDirectory() {
        return fileDirectory;
    }

    public static void setFileDirectory(directorys fileDirectory) {
        Screendirectory.fileDirectory = fileDirectory;
    }


}
