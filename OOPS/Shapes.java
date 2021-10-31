package OOPS;

import java.util.*;

class sha {
	int lsa;
	int tsa;
	int volume;

	void print() {
		System.out.print(lsa + " " + tsa + " " + volume);
	}
}

class sphere extends sha {
	public sphere(int r) {
		this.lsa = 4 * 3 * (r * r);
		this.tsa = this.lsa;
		this.volume = (4) * (r * r * r);
	}
}

class cylinder extends sha {
	public cylinder(int r, int h) {
		this.tsa = 2 * 3 * r * (r + h);
		this.lsa = 2 * 3 * r * h;
		this.volume = 3 * (r * r) * h;
	}
}

class cube extends sha {
	public cube(int r) {
		this.lsa = 4 * (r * r);
		this.tsa = 6 * (r * r);
		this.volume = r * r * r;
	}
}

public class Shapes {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		if (x == 1) {
			int r = s.nextInt();
			sphere sp = new sphere(r);
			sp.print();

		} else if (x == 2) {
			int r = s.nextInt();
			int h = s.nextInt();
			cylinder c = new cylinder(r, h);
			c.print();
		} else {
			int r = s.nextInt();
			cube c = new cube(r);
			c.print();
		}
	}

}
