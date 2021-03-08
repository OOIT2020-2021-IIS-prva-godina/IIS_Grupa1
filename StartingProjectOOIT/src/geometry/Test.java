package geometry;

public class Test {
	
	public static void main (String[] args) {
		Point p = new Point();
		//promenljiva sadrzi referencu na objekat
		System.out.println(p);
		//obelezje x je private i nije vidljivo iz klase Test
		//System.out.println(p.x);
		
		System.out.println(p.getX()+" "+p.getY()+" "+p.isSelected());
		p.setX(10);
		p.setY(10);
		p.setSelected(true);
		System.out.println(p.getX()+" "+p.getY()+" "+p.isSelected());
		
		double result=p.distance(40, 50);
		System.out.println("Distance between points is: "+result);
		
	}
}
