package graph2;

 class edge implements Comparable<edge> {
	int v1;
	int v2;
	int weight;

	public edge(int v1, int v2, int weight) {
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;

	}
	
	@Override
	public int compareTo(edge o) {

		return this.weight-o.weight;
	}
}
