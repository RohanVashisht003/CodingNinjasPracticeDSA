package groupTest;

import java.util.Scanner;

public class sumOfPowersOfThree {

	public static boolean working(int n) {
		 while(n>0){
	          if(n%3==2){
	              return false;
	          }
	          else{
	              n=n/3;
	          }
	      }
	        return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		
		if(working(n)) {
			System.out.print("true");
		}
		else {
			System.out.print("false");
		}
	}

}
