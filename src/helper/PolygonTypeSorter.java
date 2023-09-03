package helper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

import model.Point;
import model.Polygon;

/**

 * @author Sodx
 */
public class PolygonTypeSorter {
	
	private ArrayList<Polygon> areaPolygons;
	private ArrayList<Polygon> inclusionPolygons;

	public PolygonTypeSorter(ArrayList<Polygon> poligons) {
		
		Comparator<Polygon> comp = new PolygonComparatorMaxY();	
		TreeSet<Polygon> sortedPolyMaxY = new TreeSet<Polygon>(comp);
		
		for (Polygon poly : poligons) {
			
			int iMaxY = searchIMaxY(poly.getPoints());
			poly.setIndexMaxY(iMaxY);
			
			sortedPolyMaxY.add(poly);
		}
		
		areaPolygons = new ArrayList<Polygon>(1);
		areaPolygons.add(sortedPolyMaxY.pollFirst());
		
		inclusionPolygons = new ArrayList<Polygon>(sortedPolyMaxY);	
	}

	public ArrayList<Polygon> getAreaPolygons() {
		return areaPolygons;
	}

	public ArrayList<Polygon> getInclusionPolygons() {
		return inclusionPolygons;
	}
	
	private int searchIMaxY(ArrayList<Point> points) {
		
		double maxY = points.get(0).getY();	
		int imaxY = 0;	
		double currentValue; 
		
		for (int i = 1; i < points.size(); i++) {		
			
			currentValue = points.get(i).getY();
			
			if (maxY < currentValue) {
				maxY = currentValue;
				imaxY = i;
			}	
		}	
		return imaxY;	
	}
		
}
