package Modified_files;

/**
 * this class represent a dedicated Clique class which assumes undirected graph and holds 
 * the potential Ni intersection. 
 * @author Boaz
 *
 */
public class Clique {
	private VertexSet _clique;
	private VertexSet _Ni;
	private static Graph _graph = null;
	public static void init(Graph g) { _graph = g;}
	/**
	 * start a clique with an edge: represented by the indeses a,b
	 * @param a: vertex index
	 * @param b: vertex index
	 */
	public Clique(int a, int b){
		_clique = new VertexSet();
		_clique.add(a); _clique.add(b);
		_Ni = _graph.Ni(a).intersection(_graph.Ni(b));
	}
	
	public Clique(Clique ot){
		_clique = new VertexSet(ot._clique);
		_Ni = new VertexSet(ot._Ni);
	}
	
	public Clique(Clique ot, int vertex){
		this(ot);
		this.addVertex(vertex);
	}
	
	public String toFile() {//MODIFIED
		StringBuilder sb = new StringBuilder();
		sb.append("");
		int size = size();
		
		for(int i = 0; i < size; ++i){
			sb.append(_clique.at(i));
			sb.append(",");
		}

		return sb.toString();
	}

	public int size() {return _clique.size();}
	public VertexSet clique() {return _clique;}
	public VertexSet commonNi() {return _Ni;}
	public void addVertex(int vertex){
		_clique.add(vertex);
		_Ni = _Ni.intersection(_graph.Ni(vertex));
	}
	
}
