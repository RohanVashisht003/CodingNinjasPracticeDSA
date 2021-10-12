package Hashmaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class hashmapFunctions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<>();
		map.put("abc", 12);
		System.out.println(map.get("abc"));
		System.out.println(map.size());
		
		Set<String> key = map.keySet();
		for(String s:key) {
			System.out.println(map.get(s));
		}
		
	}

}
