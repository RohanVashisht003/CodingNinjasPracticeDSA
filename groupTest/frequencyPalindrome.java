package groupTest;

import java.util.Scanner;

public class frequencyPalindrome {

	 public  static boolean fp(String str) {
			int freq[] = new int[26];
			for (int i = 0; i < str.length(); i++) {
				freq[str.charAt(i) - 'a']++;
			}

			int i, freq1 = 0, count_freq1 = 0;
			for (i = 0; i < freq.length; i++) {
				if (freq[i] != 0) {
					freq1 = freq[i];
					count_freq1 = 1;
					break;
				}
			}

			int j, freq2 = 0, count_freq2 = 0;
			for (j = i + 1; j < freq.length; j++) {
				if (freq[j] != 0) {
					if (freq[j] == freq1) {
						count_freq1++;
					} else {
						count_freq2 = 1;
						freq2 = freq[j];
						break;
					}
				}
			}

			for (int k = j + 1; k < freq.length; k++) {
				if (freq[k] != 0) {
					if (freq[k] == freq1) {
						count_freq1++;
					}
					if (freq[k] == freq2) {
						count_freq2++;
					} else 
					{
						return false;
					}
				}

				if (count_freq1 > 1 && count_freq2 > 1) {
					return false;
				}
			}

			return true;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int t = scn.nextInt();
		while (t > 0) {
			int si = scn.nextInt();
			int ei = scn.nextInt();
			if (fp(str.substring(si, ei + 1))) {
				System.out.print("true");
			} else {
				System.out.print("false");
			}
			t--;
		}
	}

}
