package Screen;


import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Index.directorys;
import Service.screens;


public class options implements interfaces {
	
	//private Directory dir = new Directory(); // ???  
	
	/**
     *
     */
    private static final String PLEASE_ENTER_THE_FILENAME = "Please Enter the Filename:";
    private ArrayList<String> fileOptions = new ArrayList<>();

    public options() {
    	
    	fileOptions.add("1. Add a File");
        fileOptions.add("2. Delete A File");
        fileOptions.add("3. Search A File");
        fileOptions.add("4. Return to Menu");
        
    }
    
    /* (non-Javadoc)
     * @see Screen.interfaces#Show()
     */
    @Override
    public void Show() {
    	System.out.println("File Options Menu");
        for (String s : fileOptions) {
            System.out.println(s);
        }

    }
    
    /* (non-Javadoc)
     * @see Screen.interfaces#GetUserInput()
     */
    @Override
    public void GetUserInput() {
        int selectedOption;
        while ((selectedOption = this.getOption()) != 4) {
            this.NavigateOption(selectedOption);
        }
    }

    @Override
    public void NavigateOption(int option) {
        
    	switch(option) {

            case 1: // Add File
                this.AddFile();
                
                this.Show();
                break;
            case 2: // Delete File
                this.DeleteFile();
                
                this.Show();
                break;
            case 3: // Search File
                this.SearchFile();
                this.Show();
                break;
            
               
                case 4: // Return to Menu

            	screens.setCurrentScreen(screens.CurrentScreen);
                screens.getCurrentScreen().Show();
                screens.getCurrentScreen().GetUserInput();
             
                break;

            default:
                System.out.println("Invalid Option");
                break;   
                
        }

    }

    /**
     * 
     */
    public void AddFile() {
        System.out.println(PLEASE_ENTER_THE_FILENAME);

        String fileName = this.getInputString();

        System.out.println("You are adding a file named: " + fileName);
        
		try {
			FileSystems.getDefault().getPath(directorys.name + fileName).toAbsolutePath();
			File file = new File(dir.getName() + fileName);
			
		      if (file.createNewFile()) {
		    	  System.out.println("File created: " + file.getName());
		    	  dir.getFiles().add(file);
		    	  
		      } else {
		        System.out.println("This File Already Exits, no need to add another");
		      }
		}catch (IOException e){
			System.out.println(e);
		}
	}
        
    
    
    /**
     * 
     */
    public void DeleteFile() {
    	
    	System.out.println(PLEASE_ENTER_THE_FILENAME);

        String fileName = this.getInputString();

        System.out.println("You are deleting a file named: " + fileName);
        
        
		Path path = FileSystems.getDefault().getPath(directorys.name + fileName).toAbsolutePath();
		File file = path.toFile();
	      if (file.delete()) {
	    	  System.out.println("Deleted File: " + file.getName());
	    	  dir.getFiles().remove(file);
	      } else {
	        System.out.println("Failed to delete file:" + fileName + ", file was not found.");
	      }
    }
    
    private directorys dir = new directorys();

    /**
     * 
     */
    public void SearchFile() {
    	
    	Boolean found = false;
    	
    	System.out.println(PLEASE_ENTER_THE_FILENAME);

        String fileName = this.getInputString();

        System.out.println("You are searching for a file named: " + fileName);
        
        List<File> files = dir.getFiles();
        
        
        for(int i = 0; i < files.size(); i++) {
			if(files.get(i).getName().equals(fileName)) {
				System.out.println("Found " + fileName);
				found = true;
			}
        }
        if (!Boolean.TRUE.equals(found)) {
        	System.out.println("File not found");
        }
    }
    
    private String getInputString() {

        try (Scanner in = new Scanner(System.in)) {
            return(in.nextLine());
        }

    }
    
    private int getOption() {
        try (Scanner in = new Scanner(System.in)) {
            int returnOption = 0;
            try {
                returnOption = in.nextInt();
            }
            catch (InputMismatchException ex) {
            	System.out.println("Invalid input");
            }
            return returnOption;
        }

    }

}
