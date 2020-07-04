package Graph_and_Tree;

import java.io.IOException;
import java.util.*;


public class Dijkstra {

    public static void main(String args[]) throws IOException {

        Dijkstra d = new Dijkstra();
        d.main1();

    }

    private void main1() {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            ArrayList<Pair>[] lis = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                lis[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                int u = sc.nextInt(), v = sc.nextInt();
                long w = sc.nextLong();

                lis[u].add(new Pair(v, w));
                lis[v].add(new Pair(u, w));
            }

            int start=0;

            long []dist = dijkstra(start,n,lis);

            for(int i=0;i<n;i++){
                System.out.println(start+" to "+i+" = "+dist[i]);
            }

        }
    }

    long[] dijkstra(int start, int n, ArrayList<Pair>[] lis) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(n, Comparator.comparingLong(pair -> pair.wt));


        long[] dist = new long[n];
        boolean[] vis = new boolean[n];

        pq.add(new Pair(start, 0));

        Arrays.fill(dist, Long.MAX_VALUE);
        dist[start] = 0;

        while (!pq.isEmpty()) {

            Pair p = pq.peek();
            pq.poll();

            int node = p.node;

            if (vis[node])
                continue;

            vis[node] = true;

            for (int i = 0; i < lis[node].size(); i++) {
                int ni = lis[node].get(i).node;
                long wi = lis[node].get(i).wt;

                if (!vis[ni]) {
                    if (dist[ni] > dist[node] + wi) {
                        dist[ni] = dist[node] + wi;
                        pq.add(new Pair(ni, dist[ni]));
                    }
                }
            }

        }

        return dist;

    }

    class Pair {

        int node;
        long wt;

        Pair(int node, long wt) {
            this.node = node;
            this.wt = wt;
        }

    }
}
