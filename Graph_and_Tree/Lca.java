class Lca{
    private final int lvl = 20;
    int[][] par=new int[MAX][lvl];
    int[] depth=new int[MAX];

    public void build_lcs(int n){
        for (int i=1; i<lvl; i++) {
            for (int node = 1; node <= n; node++) {
                if (par[node][i-1] != -1)
                    par[node][i] =
                            par[par[node][i-1]][i-1];
            }
        }
    }

    public void dfs(int cur, int prev,ArrayList<Integer>[] tree) {

        depth[cur] = depth[prev] + 1;
        par[cur][0] = prev;

        for (int i=0; i<tree[cur].size(); i++) {
            if (tree[cur].get(i) != prev) {
                dfs(tree[cur].get(i), cur, tree);
            }
        }
    }

    private int getLca(int u, int v) {
        if (depth[v] < depth[u]) {
            int t=u;
            u=v;
            v=t;
        }
        int diff = depth[v] - depth[u];
        for (int i=0; i<lvl; i++)
            if ( ((diff>>i)&1) >0)
                v = par[v][i];

        if (u == v)
            return u;

        for (int i=lvl-1; i>=0; i--)
            if (par[u][i] != par[v][i]) {
                u = par[u][i];
                v = par[v][i];
            }
        return par[u][0];
    }

}
