package generics;

public class Print {

	public static<T extends PrintInterface> void printingArray(T arr[]) {
			for(int i=0; i<arr.length; i++) {
//				System.out.println(arr[i]);
				arr[i].print();
			}
	}
	public static void main(String args[]) {
//		Integer arr[] = {1,2,3,4,5};
//		printingArray(arr);
		
//		Vehicle v[] = new Vehicle[5];
//		for(int i=0; i<v.length; i++) {
//			v[i] = new Vehicle(10*i,"BMW");
//		}
//		printingArray(v);
		
		Students s[] = new Students[5];
		for(int i=0; i<s.length; i++) {
			s[i] = new Students(2*i);
		}
		printingArray(s);
		}
	}

