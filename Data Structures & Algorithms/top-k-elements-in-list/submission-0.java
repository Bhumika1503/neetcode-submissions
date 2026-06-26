class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer,Integer> freq = new HashMap<>();

        for(int num : nums){
            freq.put(num, freq.getOrDefault(num,0) + 1);
        }
         PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(
                    (a,b) -> freq.get(b) - freq.get(a)
                );

        maxHeap.addAll(freq.keySet());

        int[] result = new int[k];

        for(int i = 0; i < k; i++){
            result[i] = maxHeap.poll();
        }

        return result;
        
        
    }
}
