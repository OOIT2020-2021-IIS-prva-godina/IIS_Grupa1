package geometry;

public class Line {

	private Point startPoint;
	private Point endPoint;
	private boolean selected;

	public Line() {
	}

	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}

	public Line(Point startPoint, Point endPoint, boolean selected) {
		this(startPoint, endPoint);
		this.selected = selected;
	}

	public double length() {
		// return this.startPoint.distance(this.endPoint.x, this.endPoint.y); nije
		// ispravno
		return this.startPoint.distance(this.endPoint.getX(), this.endPoint.getY());
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Line) {
			Line pomocna = (Line) obj;
			if (this.startPoint.equals(pomocna.startPoint) && this.endPoint.equals(pomocna.endPoint))
				return true;
			else
				return false;
		} else
			return false;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getStartPoint() {
		return this.startPoint;
	}

	public Point getEndPoint() {
		return this.endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	public boolean isSelected() {
		return this.selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String toString() {
		return startPoint + "-- >" + endPoint;
	}

}
