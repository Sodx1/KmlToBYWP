package model;

public class Point {
	
	private double x;
	private double y;
	private double z;
	
	public Point(double x, double y) {
		
		this.x = x;
		this.y = y;
		this.z = 0;
	}
	
	public Point(double x, double y, double z) {
		
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Point(String longitude, String latitude) {
		
		this.x = Double.parseDouble(longitude);
		this.y = Double.parseDouble(latitude);
		this.z = 0;
	}
	
	public Point(String longitude, String latitude, String height) {
		
		this.x = Double.parseDouble(longitude);
		this.y = Double.parseDouble(latitude);
		this.z = Double.parseDouble(height);
	}
		
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}
	
}
