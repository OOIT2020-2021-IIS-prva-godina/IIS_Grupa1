package geometry;

public class Point {
	
	private int x;
	private int y;
	private boolean selected;
	
	
	public double distance(int x2, int y2){
		double dx=this.x-x2;
		double dy=this.y-y2;
		double d=Math.sqrt(dx*dx + dy*dy);
		return d;
	}
	
	public void setX(int x) {
		this.x=x;
	}
	public int getX(){
		return this.x;
	}
	public void setY(int y) {
		this.y=y;
	}
	public int getY(){
		return this.y;
	}
	public void setSelected(boolean selected) {
		this.selected=selected;
	}
	public boolean isSelected(){
		return this.selected;
	}
}
