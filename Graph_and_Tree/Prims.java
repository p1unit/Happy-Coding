package Graph_and_Tree;

import java.io.IOException;
import java.util.*;

public class Prims {
    ArrayList<Pair> []lis;
    int n;

    long []par;
    long []key;
    int ans = 0;

    public static void main(String args[]) throws IOException {

        Prims p = new Prims();
        p.main1();

    }

    private void main1() {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            int m = sc.nextInt();

            lis = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                lis[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                int u = sc.nextInt(), v = sc.nextInt();
                long w = sc.nextLong();

                lis[u].add(new Pair(v, w));
                lis[v].add(new Pair(u, w));
            }

            prims();
            if(ans!=-1) {
                for (int i = 0; i < n; i++) {
                    System.out.println("Weight of " + i + " is " + key[i] + " parent of " + i + " is " + par[i]);
                }
            }
            ans=0;
        }
    }

    void prims() {

        PriorityQueue<Pair> pq = new PriorityQueue<>(n, Comparator.comparingLong(pair -> pair.wt));
        key = new long[n];
        par = new long[n];
        Arrays.fill(key, Long.MAX_VALUE);

        pq.add(new Pair(0, 0));

        boolean visited[] = new boolean[n];
        key[0] = 0;

        while (!pq.isEmpty()) {

            Pair p = pq.peek();
            visited[p.node] = true;
            pq.poll();

            for (int i = 0; i < lis[p.node].size(); i++) {

                if (!visited[lis[p.node].get(i).node] && key[lis[p.node].get(i).node] > lis[p.node].get(i).wt) {
                    key[lis[p.node].get(i).node] = lis[p.node].get(i).wt;
                    par[lis[p.node].get(i).node] = p.node;
                    pq.add(new Pair(lis[p.node].get(i).node, key[lis[p.node].get(i).node]));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ans = -1;
                System.out.println("Disconnected Graph");
                break;
            }

        }
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
