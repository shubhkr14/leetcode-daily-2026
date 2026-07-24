class Twitter {

    private static int time = 0;

    class Tweet {
        int id;
        int time;

        Tweet(int id, int time){
            this.id = id;
            this.time = time;
        }
    }

    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<Tweet>> tweetMap;

    public Twitter(){
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId){
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>())
                .add(new Tweet(tweetId, time++));
    }

    public List<Integer> getNewsFeed(int userId){
        PriorityQueue<Tweet> pq =
                new PriorityQueue<>((a, b) -> b.time - a.time);

        followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);

        for (int followee : followMap.get(userId)){
            List<Tweet> tweets = tweetMap.get(followee);
            if (tweets != null){
                for (Tweet t : tweets){
                    pq.offer(t);
                }
            }
        }

        List<Integer> res = new ArrayList<>();

        while (!pq.isEmpty() && res.size() < 10){
            res.add(pq.poll().id);
        }

        return res;
    }

    public void follow(int followerId, int followeeId){
        followMap.computeIfAbsent(followerId, k -> new HashSet<>())
                 .add(followeeId);
    }

    public void unfollow(int followerId, int followeeId){
        if (followerId != followeeId &&
            followMap.containsKey(followerId)){
            followMap.get(followerId).remove(followeeId);
        }
    }
}