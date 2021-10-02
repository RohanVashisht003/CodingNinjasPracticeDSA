package generics;

public class Pair<T,S> {

	private T first;
	private S second;

	public Pair() {
		// TODO Auto-generated constructor stub
	}
	public Pair(T first, S second) {
		// TODO Auto-generated constructor stub
		this.first = first;
		this.second = second;
	}
	
//	First
	public T getFirst() {
		return this.first;
	}
	
	public void setFirst(T data) {
		this.first = data;
	}
	
//	Second
	public S getSecond() {
		return this.second;
	}
	
	public void setSecond(S data) {
		this.second = data;
	}
}
