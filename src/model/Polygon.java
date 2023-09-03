package model;

import java.util.ArrayList;


public class Polygon {
	
	private ArrayList<Point> points;
	private int indexMinX;
	private int indexMaxX;
	private int indexMinY;
	private int indexMaxY;
	private int id;
	
	public Polygon() {
		
		points = new ArrayList<Point>();
	}
	
	public Polygon(ArrayList<Point> arrCoord) {
		
		points = arrCoord;
	}
		
	public ArrayList<Point> getPoints() {
		return points;
	}
	
	public void setPoints(ArrayList<Point> points) {
		this.points = points;
	}

	public void setPoint(Point coord) {
		this.points.add(coord);
	}
	
	public Point getPoint(int index) {
		return points.get(index);
	}
		
	public int getAmountPoints() {
		return points.size();
	}
	
	public void setIndexMinX(int indexMinX) {
		this.indexMinX = indexMinX;
	}

	public void setIndexMaxX(int indexMaxX) {
		this.indexMaxX = indexMaxX;
	}

	public void setIndexMinY(int indexMinY) {
		this.indexMinY = indexMinY;
	}

	public void setIndexMaxY(int indexMaxY) {
		this.indexMaxY = indexMaxY;
	}

	public int getIndexMinX() {
		return indexMinX;
	}

	public int getIndexMaxX() {
		return indexMaxX;
	}

	public int getIndexMinY() {
		return indexMinY;
	}

	public int getIndexMaxY() {
		return indexMaxY;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
