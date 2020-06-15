public void add(Map<Integer,Integer>map,int x){
    if(map.containsKey(x))
        map.put(x, map.get(x) + 1);
    else
        map.put(x, 1);
}

public void remove(Map<Integer,Integer> map, int x){
    if(!map.containsKey(x))
        return;
    int curr = map.get(x);
    if(curr == 1)
        map.remove(x);
    else
        map.put(x,curr-1);
}