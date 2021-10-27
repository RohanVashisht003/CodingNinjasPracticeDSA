package graph2;

import java.util.Scanner;
import java.util.Arrays;

public class kruskalAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int e = scn.nextInt();

		edge edges[] = new edge[e];
		for (int i = 0; i < e; i++) {
			int v1 = scn.nextInt();
			int v2 = scn.nextInt();

			int weight = scn.nextInt();
			edge E = new edge(v1, v2, weight);
			edges[i] = E;
		}

		edge mst[] = kruskal(edges, n);
		for (int i = 0; i < mst.length; i++) {
			if (mst[i].v1 < mst[i].v2) {
				System.out.println(mst[i].v1 + " " + mst[i].v2 + " " + mst[i].weight);
			} else {
				System.out.println(mst[i].v2 + " " + mst[i].v1 + " " + mst[i].weight);
			}
		}
	}

	public static edge[] kruskal(edge[] edges, int n) {

		Arrays.sort(edges);
		edge mst[] = new edge[n - 1];
		int parent[] = new int[n];
		for (int j = 0; j < n; j++) {
			parent[j] = j;
		}
		int count = 0, i = 0;
		while (count != n - 1) {
			edge currentEdge = edges[i++];
			int v1Parent = findParent(currentEdge.v1, parent);
			int v2Parent = findParent(currentEdge.v2, parent);
			if (v1Parent != v2Parent) {
//				include current edge
				mst[count] = currentEdge;
				count++;
				parent[v1Parent] = v2Parent;
			}
		}
		return mst;
	}

	public static int findParent(int v, int parent[]) {
		if (v == parent[v]) {
			return v;
		}
		return findParent(parent[v], parent);
	}

}
