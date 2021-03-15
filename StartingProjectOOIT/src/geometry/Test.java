package geometry;

public class Test {

	public static void main(String[] args) {

		// Vezbe 2.
		Point p = new Point();
		// promenljiva sadrzi referencu na objekat
		System.out.println(p);
		// obelezje x je private i nije vidljivo iz klase Test
		// System.out.println(p.x);

		System.out.println(p.getX() + " " + p.getY() + " " + p.isSelected());
		p.setX(10);
		p.setY(10);
		p.setSelected(true);
		System.out.println(p.getX() + " " + p.getY() + " " + p.isSelected());

		double result = p.distance(40, 50);
		System.out.println("Distance between points is: " + result);

		// Vezbe 3.
		Point p1 = new Point();
		p1.setX(15);
		p1.setY(27);
		p1.setSelected(true);

		Line l1 = new Line();
		Rectangle r1 = new Rectangle();
		Circle c1 = new Circle();
		// 1. Inicijalizovati x koordinatu tacke p
		// na vrednost y koordinate tacke p1
		System.out.println("Stara vrednost x koordinate tacke p: " + p.getX());
		p.setX(p1.getY());
		System.out.println("Nova vrednost x koordinate tacke p: " + p.getX());

		// 2. Postaviti za pocetnu tacku linije l1 tacku p, a
		// za krajnju tacku linije l1 tacku p1
		l1.setStartPoint(p);
		l1.setEndPoint(p1);

		// 3. Postaviti y koordinatu krajnje tacke l1 na 23
		System.out.println("Stara vrednost y koordinate krajnje tacke l1: " + l1.getEndPoint().getY());
		l1.getEndPoint().setY(23);
		System.out.println("Nova vrednost y koordinate krajnje tacke l1: " + l1.getEndPoint().getY());

		// 4. Inicijalizovati x koordinatu pocetne tacke linije l1
		// na vrednost y koordinate krajnje tacke linije l1
		System.out.println("Stara vrednost x koordinate pocetne tacke l1: " + l1.getStartPoint().getX());
		l1.getStartPoint().setX(l1.getEndPoint().getY());
		System.out.println("Nova vrednost x koordinate pocetne tacke l1: " + l1.getStartPoint().getX());

		// 5. Postaviti x koordinatu krajnje tacke l1 na vrednost
		// duzine linije l1 umanjene za vrednost zbira x i y
		// koordinate pocetne tacke linije l1
		l1.getEndPoint().setX((int)(l1.length()-(l1.getStartPoint().getX()+l1.getStartPoint().getY())));

		// 6. Postaviti x koordinatu tacke gore levo pravougaonika
		// r1 na vrednost 10 i y koordinatu na vrednost 15
		r1.setUpperLeftPoint(p1);//inicijalizujemo vrednost tacke gore levo inace vraca Null pointer exception
		r1.getUpperLeftPoint().setX(10);
		r1.getUpperLeftPoint().setY(15);
		System.out.println("X koordinata tacke gore levo: " + r1.getUpperLeftPoint().getX());
		System.out.println("Y koordinata tacke gore levo: " + r1.getUpperLeftPoint().getY());
		
		// 7. Postaviti centar kruga c1 na koordinate tacke
		// gore levo od r1
		c1.setCenter(r1.getUpperLeftPoint()); //nema potrebe postavljati koordinate pojedinacno
		System.out.println("X koordinata centra: " + c1.getCenter().getX());
		System.out.println("Y koordinata centra: " + c1.getCenter().getY());

		// 8. Postaviti x koordinatu centra kruga c1 na vrednost razlike
		// povrsine pravougaonika r1 i y koordinate pocetne tacke linije l1
		r1.setHeight(20);
		r1.setWidth(30);
		c1.getCenter().setX(r1.area()-l1.getStartPoint().getY());
		System.out.println("X koordinata centra: " + c1.getCenter().getX());

	}
}
