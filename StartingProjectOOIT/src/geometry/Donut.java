package geometry;

public class Donut extends Circle {

	private int innerRadius;

	public Donut() {
	}

	public Donut(Point center, int radius, int innerRadius) {
		// this.center - ne moze jer je private u Circle klasi

		/*
		 * this.setCenter(center); this.setRadius(radius);
		 */
		super(center, radius);// prva naredba
		this.innerRadius = innerRadius;
	}

	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		this(center, radius, innerRadius);
		//this.setSelected(selected);//jer je selected u Circle private
		this.selected = selected;//mogu ako je selected u Circle protected
	}
	
	public double area() {
		return super.area() - innerRadius*innerRadius*Math.PI;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Donut) {
			Donut pomocni = (Donut) obj;
			if (getCenter().equals(pomocni.getCenter()) && getRadius() == pomocni.getRadius() && innerRadius == pomocni.innerRadius) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public boolean contains(int x, int y) {
		double dFromCenter = getCenter().distance(x, y);
		return super.contains(x, y) && dFromCenter > innerRadius;
	}
	
	public boolean contains(Point p) {
		double dFromCenter = getCenter().distance(p.getX(), p.getY());
		return super.contains(p.getX(), p.getY()) && dFromCenter > innerRadius;
	}

	public String toString() {
		return super.toString()+", innerRadius="+innerRadius;
	}
	
	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}

}
