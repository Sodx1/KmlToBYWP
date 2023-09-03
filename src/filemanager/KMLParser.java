package filemanager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import model.Point;
import model.Polygon;


public class KMLParser {
	
	Document document;
	
	public KMLParser(File file) {
		
		try {
			document = Jsoup.parse(file, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
		
	public ArrayList<Polygon> getPolygons() {
		
		ArrayList<Polygon> poligons = new ArrayList<>();
		
		if (document != null) {
		
			Elements elements = document.select("coordinates");
						
			for (int i = 0; i < elements.size(); i++) {						
				
				String[] points = elements.get(i).text().split(" ");			// Внешний контур
				Polygon poligon = new Polygon();
				
				for (int j = 0; j < points.length; j++) {						
					
					String[] coord = points[j].split(",");				    	// Внутрений контур 
					
					if (coord.length == 2) 
						poligon.setPoint(new Point(coord[0], coord[1]));
					
					else if (coord.length == 3) 
						poligon.setPoint(new Point(coord[0], coord[1], coord[2]));
				}
				poligons.add(i, poligon);
			}
		}
		return poligons;	
	}
		
}
	
