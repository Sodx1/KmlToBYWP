package app;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import filemanager.BYWPCreator;
import filemanager.Filemanager;
import filemanager.KMLParser;
import helper.PolygonTypeSorter;
import model.Polygon;

public class Main {

	public static void main(String[] args) {
					
		JFileChooser fileopen = new JFileChooser();		//"data/"
		FileNameExtensionFilter filter = new FileNameExtensionFilter("kml", "KML");
		fileopen.setFileFilter(filter);
		int ret = fileopen.showDialog(null, "Открыть файл KML");                
				
		switch(ret) {
		case JFileChooser.APPROVE_OPTION: 
			
			File file = fileopen.getSelectedFile();
			
			String[] name = file.getName().split("\\.");
			String pathBYWP = file.getParent() + "\\" + name[0] + ".bywp";
			
			KMLParser kml = new KMLParser(new File(file.getPath()));
			PolygonTypeSorter polyType = new PolygonTypeSorter(kml.getPolygons());
			ArrayList<Polygon> areaPolygons = polyType.getAreaPolygons();
			ArrayList<Polygon> inclusionPolygons = polyType.getInclusionPolygons();
			
			BYWPCreator bywp = new BYWPCreator();
			ArrayList<String> data = bywp.getDataList(areaPolygons, inclusionPolygons);
						
			Filemanager fm = new Filemanager(pathBYWP);
			fm.writeData(data);
			
			break;
		case JFileChooser.CANCEL_OPTION:
			break;
		case JFileChooser.ERROR_OPTION:
			break;		
		}
	
	}
}
