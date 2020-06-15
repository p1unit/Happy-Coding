int[] prime = new int[MAX];

    void spfSieve(){

        for(int i=0;i<MAX;++i){
            prime[i] = i;
        }

        int maxPr = -1;

        for(int i=2;i<MAX;++i){
            long temp  = (long) i*(long) i;
            if(temp>MAX)
                continue;
            if(prime[i]==i){
                for(int j=i*i;j<MAX;j+=i){
                    prime[j] = i;
                    if(i==3137)
                        maxPr = max(maxPr,j);
                }
            }
        }
    }

    HashMap<Integer,Integer> getFact(int num){

        HashMap<Integer,Integer> map = new HashMap<>();

        while (num>1){
            map.put(prime[num],map.getOrDefault(prime[num],0)+1);
            num =  num/prime[num];
        }
        return map;
    }
