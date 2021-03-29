package geometry;

public class Rectangle {

	private Point upperLeftPoint;
	private int width;
	private int height;
	private boolean selected;

	public Rectangle() {
	}

	public Rectangle(Point upperLeftPoint, int width, int height) {
		this.upperLeftPoint = upperLeftPoint;
		this.width = width;
		this.height = height;
	}

	public Rectangle(Point upperLeftPoint, int width, int height, boolean selected) {

		this(upperLeftPoint, width, height);
		this.selected = selected;
	}

	public int area() {
		return this.width * this.height;
	}

	public int circumference() {
		return this.width * 2 + this.height * 2;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Rectangle) {
			Rectangle pomocna = (Rectangle) obj;
			if (this.upperLeftPoint.equals(pomocna.upperLeftPoint) && 
					this.width==pomocna.width && this.height==pomocna.height)
				return true;
			else
				return false;
		} else
			return false;
	}
	
	public boolean contains(int x, int y) {
		if (upperLeftPoint.getX()<=x && x<=upperLeftPoint.getX()+width 
				&& upperLeftPoint.getY()<=y && y<=upperLeftPoint.getY()+height)
			return true;
		return false;
	}
	
	public boolean contains(Point p) {
		if (upperLeftPoint.getX()<=p.getX() && p.getX()<=upperLeftPoint.getX()+width 
				&& upperLeftPoint.getY()<=p.getY() && p.getY()<=upperLeftPoint.getY()+height)
			return true;
		return false;
	}

	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}

	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String toString() {
		return "Upper left point:"+ upperLeftPoint+", width ="+ width +",height = "+height;
	}

}
