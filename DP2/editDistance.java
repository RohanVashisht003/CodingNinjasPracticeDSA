package DP2;

public class editDistance {

	public static int editDistance(String s, String t, int i, int j) {
		if (i == s.length()) {
			return t.length()-j; 
		}
		if(j==t.length()) {
			return s.length()-i;
		}
		
		int ans = 0;
		if (s.charAt(i) == t.charAt(j)) {
			return editDistance(s, t, i + 1, j + 1);

		} else {
//			replace
			int ans1 = editDistance(s, t, i + 1, j + 1);
//			remove
			int ans2 = editDistance(s, t, i + 1, j);
//			insert
			int ans3 = editDistance(s, t, i, j + 1);

			return Math.min(ans1, Math.min(ans2, ans3)) + 1;

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(editDistance("whgtdwhgtdg", "aswcfg", 0, 0));
	}

}
