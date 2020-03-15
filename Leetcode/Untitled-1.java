class MyHashSet {

    private int hash(int key) {
        return key % 1000001;
    }

    private int data[] = new int[1000000];

    /** Initialize your data structure here. */
    public MyHashSet() {
        for (int i = 0; i < data.length; i++) {
            data[i] = -1;
        }
    }

    public void add(int key) {
        int code = hash(key);
        if (data[code] == key)
            return;
        data[code] = key;
    }

    public void remove(int key) {
        int code = hash(key);
        data[code] = -1;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {

        int code = hash(key);
        return data[code] != -1;
    }
}
/**
 * 
 * ["MyHashSet","remove","add","remove","add","add","remove","add","contains","add","contains","add","contains","remove","remove","contains","add","add","add","add","contains","remove","contains","contains","remove","add","contains","add","add","contains","add","add","add","add","add","contains","add","add","remove","add","contains","add","add","add","add","remove","add","contains","add","add","add","add","remove","remove","contains","contains","add","contains","contains","add","contains","remove","contains","contains","remove","add","add","add","contains","add","contains","add","add","add","add","add","contains","contains","remove","contains","add","remove","add","add","add","contains","add","add","add","add","add","add","remove","add","contains","add","add","add","contains","add","add"]
 * [[],[1],[9],[24],[53],[84],[90],[34],[9],[39],[84],[18],[9],[2],[34],[18],[68],[93],[62],[24],[76],[15],[88],[46],[32],[56],[62],[68],[99],[9],[69],[74],[55],[91],[21],[83],[43],[47],[91],[17],[16],[3],[2],[29],[15],[59],[54],[2],[86],[18],[30],[69],[66],[15],[76],[55],[1],[87],[52],[61],[84],[23],[61],[19],[99],[33],[63],[72],[45],[92],[72],[7],[29],[74],[0],[97],[63],[92],[85],[0],[83],[17],[32],[35],[91],[80],[95],[75],[18],[18],[38],[43],[14],[40],[46],[25],[42],[99],[47],[57],[25]]
 * 
 * 
 * [null,null,null,null,null,null,null,null,true,null,true,null,true,null,null,true,null,null,null,null,false,null,false,false,null,null,true,null,null,true,null,null,null,null,null,false,null,null,null,null,false,null,null,null,null,null,null,true,null,null,null,null,null,null,false,true,null,false,false,null,true,null,true,false,null,null,null,null,false,null,true,null,null,null,null,null,true,true,null,false,null,null,null,null,null,false,null,null,null,null,null,null,null,null,false,null,null,null,true,null,null]
 * 
 * [null,null,null,null,null,null,null,null,true,null,true,null,true,null,null,true,null,null,null,null,false,null,false,false,null,null,true,null,null,true,null,null,null,null,null,false,null,null,null,null,false,null,null,null,null,null,null,true,null,null,null,null,null,null,false,true,null,false,false,null,true,null,true,false,null,null,null,null,false,null,true,null,null,null,null,null,true,true,null,true,null,null,null,null,null,false,null,null,null,null,null,null,null,null,false,null,null,null,true,null,null]
 */

/**
 * Your MyHashSet object will be instantiated and called as such: MyHashSet obj
 * = new MyHashSet(); obj.add(key); obj.remove(key); boolean param_3 =
 * obj.contains(key);
 */