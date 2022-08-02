package Index;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;


public class directorys {

   public static final String name = "scr/main/directory/";

    private ArrayList<File> files = new ArrayList<>();
    
    Path path = FileSystems.getDefault().getPath(name).toAbsolutePath();
    
    File Defiles = path.toFile();
       
    public String getName() {
        return name;
    }
    
    public void print() {
    	System.out.println("Existing Files: ");
    	files.forEach(System.out::println);
    }

    public List<File> fillFiles() {
    	
        File[] directoryFiles = Defiles.listFiles();
        
        
        
    	files.clear();
    	for (int i = 0; i < directoryFiles.length; i++) {
    		if (directoryFiles[i].isFile()) {
    			files.add(directoryFiles[i]);
    		}
    	}
    	
    	Collections.sort(files);
    	
    	return files;
    }

    public List<File> getFiles() {
    	
    	fillFiles();
    	return files;
    }
    
}
