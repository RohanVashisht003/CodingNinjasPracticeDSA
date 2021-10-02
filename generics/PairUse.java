package generics;

public class PairUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pair<String, Integer> pInner = new Pair<>();
		Pair<String,Pair<String, Integer>> p = new Pair<>();
		p.setFirst("Hello this is Rohan Sharma");
		pInner.setFirst("Rohan");
		pInner.setSecond(100);
		p.setSecond(pInner);
		
		System.out.println(p.getFirst());
		System.out.println(p.getSecond().getSecond());

	}

}
