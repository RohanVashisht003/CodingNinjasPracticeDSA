package OOPS;

import java.util.*;

class Player {
	String p_name;
	int jnumber, t_runs, innings, notouts;
	int avg;

	void set(String name, int number, int runs, int inn, int nos) {
		this.p_name = name;
		this.jnumber = number;
		this.t_runs = runs;
		this.innings = inn;
		this.notouts = nos;
		findavg();
	}

	void findavg() {
		this.avg = this.t_runs / (this.innings - this.notouts);
	}

	void print() {
		System.out.println(this.p_name + " " + this.jnumber + " " + this.t_runs + " " + this.innings + " "
				+ this.notouts + " " + this.avg);
	}

}

public class averageCrickters {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while (t-- > 0) {
			String name = s.next();
			int num = s.nextInt();
			int runs = s.nextInt();
			int inn = s.nextInt();
			int nos = s.nextInt();
			Player p = new Player();
			p.set(name, num, runs, inn, nos);
			p.print();
		}
	}
}
