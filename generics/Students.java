package generics;

public class Students implements PrintInterface {
	public int rollNo;

	public Students(int rollNo) {
		super();
		this.rollNo = rollNo;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println(rollNo);
	}
}
