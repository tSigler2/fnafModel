package fnafModel;
import java.util.LinkedList;

public class GraphClass {
	int V;
	LinkedList<Integer>[] edges;
	
	@SuppressWarnings("unchecked")
	GraphClass(int V){
		this.V = V;
		edges = new LinkedList[V];
		for(int i = 0; i < edges.length; i++) {
			edges[i] = new LinkedList<Integer>();//
		}
	}
	
	void addEdges(int v, int w) {
		edges[v].add(w);
		edges[w].add(v);
	}
}
