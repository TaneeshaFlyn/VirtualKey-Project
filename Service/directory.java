package Service;

import java.io.File;

import Directory.directory;


public class directory {

    private static Directory fileDirectory = new Directory();
    
    public static void PrintFiles() {
    	
    	fileDirectory.fillFiles();

        for (File file : directory.getFileDirectory().getFiles())
        {
            System.out.println(file.getName());
        }
    }
    public static directory getFileDirectory() {
        return fileDirectory;
    }

    public static void setFileDirectory(directory fileDirectory) {
        directory.fileDirectory = fileDirectory;
    }


}
