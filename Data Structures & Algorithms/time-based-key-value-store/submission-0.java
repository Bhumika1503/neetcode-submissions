class TimeMap {
    class Node {
        String val;
        int time;
        Node(String val, int time) {
            this.val = val;
            this.time = time;
        }
    }
    HashMap<String, ArrayList<Node>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Node(value, timestamp));
    }
    public String get(String key, int timestamp) {

        if (!map.containsKey(key))
            return "";
        ArrayList<Node> list = map.get(key);
        int l = 0, r = list.size() - 1;
        String ans = "";

        while (l <= r) {

            int m = l + (r - l) / 2;

            if (list.get(m).time <= timestamp)
            {
                ans = list.get(m).val;
                l = m + 1;
            } 
            else 
                r = m - 1; 
        }
        return ans;
    }
}