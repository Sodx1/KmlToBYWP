package helper;

import java.util.Comparator;

import model.Polygon;

public class PolygonComparatorMaxY implements Comparator<Polygon> {

	@Override
	public int compare(Polygon a, Polygon b) {
		  		
		double maxA = a.getPoint(a.getIndexMaxY()).getY();
		double maxB = b.getPoint(b.getIndexMaxY()).getY();
		
    	if(maxA < maxB)  return 1;
            
        else if(maxA > maxB)  return -1;
              
        else if(maxA == maxB) return -1;
    	
        else  return 0;         
	}
}
   
