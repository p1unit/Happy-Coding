public void add(Map<Integer,Integer>map,int x){
    if(map.containsKey(x))
    	map.put(x, map.get(x) + 1);
    else
    	map.put(x, 1);
}

public void remove(Map<Integer,Integer>map,int x){
    int curr = map.get(x);
    if(curr==null)
        return;
    if(curr == 1)
    	hashMap.remove(x);
    else
    	hashMap.put(x,curr-1);
}
