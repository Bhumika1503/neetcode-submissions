class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        for (char c : tasks)
            freq[c - 'A']++;

        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int f : freq)
            if (f > 0)
                maxHeap.offer(f);

        Queue<int[]> q = new LinkedList<>();

        int time = 0;

        while (!maxHeap.isEmpty() || !q.isEmpty()) {

            time++;

            if (!maxHeap.isEmpty()) {

                int count = maxHeap.poll() - 1;

                if (count > 0)
                    q.offer(new int[]{count, time + n});
            }

            if (!q.isEmpty() && q.peek()[1] == time)
                maxHeap.offer(q.poll()[0]);
        }

        return time;
    }
}
