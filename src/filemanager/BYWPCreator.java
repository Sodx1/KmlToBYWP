package filemanager;

import java.util.ArrayList;



import model.Point;
import model.Polygon;

public class BYWPCreator {
	
	private StructBYWP structBYWP;
	private int idInclusion = -1;
		
	public ArrayList<String> getDataList(ArrayList<Polygon> areaPolygons, ArrayList<Polygon> inclusionPolygons) {
		
		ArrayList<String> polygons = intro();		
		
		for (Polygon poly : areaPolygons) {	
			for (Point poi : poly.getPoints()) {	
				polygons.add(areaPolygon(poi.getY(), poi.getX(), poi.getZ()));				
			}		
		}	
		for (Polygon poly : inclusionPolygons) {
						
			idInclusion++;
			for (Point poi : poly.getPoints()) {				
				polygons.add(inclusionPolygon(poi.getY(), poi.getX(), poi.getZ()));				
			}		
		}
		return polygons;
	}
	
	public ArrayList<String> intro() {
		
		ArrayList<String> intro = new ArrayList<String>();
		intro.add("@Saved by BOYING,WP");
		intro.add("0" + "\t" + "FR");
		intro.add("0" + "\t" +	"ZA");
		intro.add("false" + "\t" + "PT"); 
		intro.add("0" + "\t" + "NM");
		
		return intro;
	}
	
	public String areaPolygon(double latitude, double longitude, double altitude) {
		
		structBYWP = new StructBYWP();
		
		structBYWP.y = latitude;	
		structBYWP.x = longitude;
		structBYWP.z = altitude;
		structBYWP.par15 = 1;
		structBYWP.par16 = "PP";
		return formBYWPPole(structBYWP);	
	}
	
	public String inclusionPolygon(double latitude, double longitude, double altitude) {
		
		structBYWP = new StructBYWP();
		
		structBYWP.y = latitude;	
		structBYWP.x = longitude;
		structBYWP.z = altitude;
		structBYWP.par14 = "0";
		structBYWP.par15 = 0;
		structBYWP.par16 = "yuan";
		structBYWP.par17 = "1";
		structBYWP.order = idInclusion+"";
		structBYWP.par19 = "OP";
		
		return formBYWPOkolki(structBYWP);	
	}
	
	
	private class StructBYWP {
		
		private int par1 = 0;
		private int par2 = 0;
		private int par3 = 0;
		private int par4 = 0;
		private int par5 = 0;
		private int par6 = 0;
		private int par7 = 0;
		private int par8 = 0;
		private double y = 0;
		private double x = 0;
		private double z = 0;
		private String par12 = "null";
		private double par13 = 0;
		private String par14 = "";
		private int par15 = 0;
		private String par16;
		private String par17;
		private String order;
		private String par19;	
	}
	
	private String formBYWPPole(StructBYWP bywp) {
		
		String command = bywp.par1 + "\t" + bywp.par2 + "\t"  + bywp.par3 + "\t" + bywp.par4 + "\t" +
				bywp.par5 + "\t" + bywp.par6 + "\t" + bywp.par7 + "\t" + bywp.par8 + "\t"+
				bywp.y + "\t" + bywp.x + "\t" + bywp.z  + "\t" + bywp.par12 + "\t" + bywp.par13 +"\t"+
				bywp.par14+"\t"+ bywp.par15 +"\t"+ bywp.par16; 
		return command;
	}
	
	
	private String formBYWPOkolki(StructBYWP bywp) {
		
		String command = bywp.par1 + "\t" + bywp.par2 + "\t"  + bywp.par3 + "\t" + bywp.par4 + "\t" +
				bywp.par5 + "\t" + bywp.par6 + "\t" + bywp.par7 + "\t" + bywp.par8 + "\t"+
				bywp.y + "\t" + bywp.x + "\t" + bywp.z  + "\t" + bywp.par12 + "\t" + bywp.par13 +"\t"+
				bywp.par14+"\t"+ bywp.par15 +"\t"+ bywp.par16+"\t"+bywp.par17+"\t"+bywp.order +"\t"+bywp.par19; 
		return command;
	}
	


}
