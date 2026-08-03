class Twitter {

    private int time;
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<Tweet>> tweetMap;
    public Twitter() {
        time = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    class Tweet {
        int id;
        int time;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new Tweet(tweetId, time++));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> b[0] - a[0]
        );
        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);
        for (int followee : followMap.get(userId)) {

            if (!tweetMap.containsKey(followee))
                continue;
            List<Tweet> tweets = tweetMap.get(followee);
            int index = tweets.size() - 1;
            Tweet t = tweets.get(index);
            pq.offer(new int[]{
                    t.time,
                    t.id,
                    followee,
                    index - 1
            });
        }
        while (!pq.isEmpty() && feed.size() < 10) {
            int[] curr = pq.poll();
            feed.add(curr[1]);
            int followee = curr[2];
            int index = curr[3];

            if (index >= 0) 
            {
                Tweet t = tweetMap.get(followee).get(index);
                pq.offer(new int[]{
                        t.time,
                        t.id,
                        followee,
                        index - 1
                });
            }
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!followMap.containsKey(followerId))
            return;
        if (followeeId != followerId)
            followMap.get(followerId).remove(followeeId);
    }
}
