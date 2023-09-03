package filemanager;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Filemanager {
	
	private String path;
	
	public Filemanager(String path) {
		
		this.path = path;
	} 	
	
	public void writeData(ArrayList<String> data) {
		
		try (FileWriter writer = new FileWriter(path, false)) {         
			
			for (String line : data) { 
				writer.write(line + System.getProperty("line.separator").toString());
            	writer.flush();
            	
            	}
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        } 	
	}
	
	public void writeData(String data) {
		
		try (FileWriter writer = new FileWriter(path, false)) {
           
			writer.write(data);
            writer.flush();      
        }
        catch(IOException ex){      
            System.out.println(ex.getMessage());
        } 	
	}
	
}
