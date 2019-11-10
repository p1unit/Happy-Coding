package Graph_and_Tree;
class Int_Segment_Tree{

    int[] tree;
    int MAX=2000001;

    public Int_Segment_Tree(int MAX) {
        this.MAX=MAX;
        this.tree=new int[MAX];
    }

    private int action(int child1, int child2) {
        // ToDo :- add method function here
        return 0;
    }

    private int outOfBound() {
        // ToDo - add out of bound value here
        return 0;
    }

    public void build(int[] arr,int idx,int start,int end){
        if(start==end){
            this.tree[idx]=arr[start];
            return;
        }
        int mid=(start+end)/2;
        build(arr,2*idx+1,start,mid);
        build(arr,2*idx+2,mid+1,end);
        this.tree[idx]=action(this.tree[2*idx+1],this.tree[2*idx+2]);
    }

    public int query(int idx,int l,int r,int start,int end){
        if(start>r || end<l)
            return outOfBound();
        if(start>=l && end<=r)
            return this.tree[idx];
        int mid=(start+end)/2;
        return action(query(2*idx+1,l,r,start,mid),query(2*idx+2,l,r,mid+1,end));
    }

    public void update(int[] arr,int idx,int n,int start,int end){
        if(start==end){
            this.tree[idx]=arr[start];
            return;
        }
        int mid=(start+end)/2;
        if(n<=mid)
            update(arr,2*idx+1,n,start,mid);
        else
            update(arr,2*idx+2,n,mid+1,end);

        this.tree[idx]=action(this.tree[2*idx+1],this.tree[idx+2]);
    }

}