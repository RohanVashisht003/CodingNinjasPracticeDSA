package graphs1;

import java.util.Scanner;

public class codingNinjas {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int row = scn.nextInt();
		int col = scn.nextInt();
		char arr[][] = new char[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				arr[row][col] = scn.next().charAt(0);
			}
		}
//		System.out.println(solve(args, row, col));
	}

}
