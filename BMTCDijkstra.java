                                        
                
import java.util.Scanner;
class BMTCDijkstra {

    static final int INF = 9999;

    // Find Minimum Distance Vertex
    int minDistance(int dist[], boolean visited[], int V) {

        int min = INF;
        int minIndex = -1;

        for (int v = 0; v < V; v++) {

            if (!visited[v] && dist[v] < min) {
                min = dist[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    // Dijkstra Algorithm
    void dijkstra(int graph[][], int src, int V) {

        int dist[] = new int[V];

        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; i++) {

            dist[i] = INF;
            visited[i] = false;
        }

        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {

            int u = minDistance(dist, visited, V);

            visited[u] = true;

            for (int v = 0; v < V; v++) {

                if (!visited[v] &&
                    graph[u][v] != 0 &&
                    dist[u] != INF &&
                    dist[u] + graph[u][v] < dist[v]) {

                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        System.out.println("\nShortest Distance from MJC:");

        for (int i = 0; i < V; i++) {

            System.out.println("To Vertex " + i + " = " + dist[i] + " min");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of vertices:");
        int V = sc.nextInt();

        int graph[][] = new int[V][V];

        System.out.println("Enter adjacency matrix:");

        for (int i = 0; i < V; i++) {

            for (int j = 0; j < V; j++) {

                graph[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter source vertex:");
        int src = sc.nextInt();

        BMTCDijkstra obj = new BMTCDijkstra();

        obj.dijkstra(graph, src, V);

        sc.close();
    }
}