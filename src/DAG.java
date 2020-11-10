import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class DAG
{
    private final int numberOfVertices;
    private int numberOfEdges;
    private final ArrayList<Integer>[] adj;   //adj[V] = adjacency list for vertex V
    private final boolean[] marked;			//list of visited vertices
    private boolean hasCycle;			//True if graph has cycle
    private final int [] indegree;			//indegree[V] = indegree of vertex V
    private final boolean[] stack;			// Order that vertices were visited


    public DAG(int numberOfVertices) {
        if(numberOfVertices < 0)
            throw new IllegalArgumentException("Number of vertices must be non negative");
        this.numberOfVertices = numberOfVertices;
        this.numberOfEdges = 0;
        indegree = new int[numberOfVertices];
        marked = new boolean[numberOfVertices];
        stack = new boolean[numberOfVertices];
        adj = (ArrayList<Integer>[]) new ArrayList[numberOfVertices];

        for(int v = 0; v < numberOfVertices; v++) {
            adj[v] = new ArrayList<>();
        }
    }

    //Returns current vertex
    public int numberOfVertices() {
        return numberOfVertices;
    }
    public int numberOfEdges() {
        return numberOfEdges;
    }
    private int validateVertex(int v) {
        if(v < 0 || v >= numberOfVertices)
            return -1;
        else
            return 1;
    }
  //Returns number of directed edges to vertex v
    public int indegree(int v) {
        if(validateVertex(v) > 0) {
            return indegree[v];
        }
        else {
            return -1;
        }

    }

    //Returns number of directed edges from vertex v
    public int outdegree(int v) {
        if(validateVertex(v) > 0)
            return adj[v].size();
        else
            return -1;
    }
    public void addEdge(int v, int w) {
        if((validateVertex(v) > 0) && (validateVertex(w) > 0)) {
            adj[v].add(w);
            indegree[w]++;
            numberOfEdges++;
        }
        else {
            System.out.println("Numbers must be between 0 and " + (numberOfVertices-1));
        }
    }
    //Returns the adjacent vertices to v
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public boolean hasCycle() {
        return hasCycle;
    }
    public void findCycle(int v) {
        marked[v] = true;
        stack[v] = true;

        for(int w : adj(v)) {
            if(!marked[w])
                findCycle(w);
            else if(stack[w]) {
                hasCycle = true;
                return;
            }
        }
        stack[v] = false;
    }

    //LCA method for DAG
    public int findLCA(int v, int w) {
        findCycle(0);
        if(hasCycle)
            return -1;         //Graph is not DAG
        else if(validateVertex(v) < 0 || validateVertex(w) < 0)
            return -1;        //Not valid vertices
        else if(numberOfEdges == 0)
            return -1;            //Graph is empty

        DAG reverse = reverse();
        ArrayList<Integer> a1 = reverse.BFS(v);
        ArrayList<Integer> a2 = reverse.BFS(w);
        ArrayList<Integer> commonAncestors = new ArrayList<>();
        boolean found = false;        //loop through BFS paths, adding all common ancestors to arraylist
        for (Integer integer : a1) {
            for (Integer value : a2) {
                if (Objects.equals(integer, value)) {
                    commonAncestors.add(integer);
                    found = true;
                }
            }
        }
        //Return first element in list - Lowest Common Ancestor
        if(found)
            return commonAncestors.get(0);
        else
            return -1;
    }
    //Reverse DAG
    public DAG reverse() {
        DAG reverse = new DAG(numberOfVertices);
        for(int v = 0; v <numberOfVertices; v++) {
            for(int w : adj(v)) {
                reverse.addEdge(w, v);
            }
        }
        return reverse;
    }

    //Prints BFS(Breadth-First search) from source s
    public ArrayList<Integer> BFS(int s)
    {
        ArrayList<Integer> order = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();

        //mark all vertices as not visited
        boolean[] visited = new boolean[numberOfVertices];
        visited[s] = true;
        queue.add(s);

        while(queue.size() != 0) {
            s = queue.poll(); //Sets s to the head of the list
            order.add(s);
            //Find adjacent vertices to s. If not visited, mark true and enqueue
            for (int n : adj[s]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return order;
    }
}


