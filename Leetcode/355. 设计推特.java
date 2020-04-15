import java.util.HashMap;

class Twitter {
    class Tweet {
        private int id;
        private long timestamp = 0;

        public Tweet(int id) {
            this.id = id;
            this.timestamp = Twitter.timestap++;
        }

    }

    class User {
        // 用户id
        private int id;
        // 自己发的tweet id
        private LinkedList<Tweet> tweets = new LinkedList<>();
        // 该用户关注的人的id
        private LinkedList<Integer> follows = new LinkedList<>();

        public User(int id) {
            this.id = id;
        }

        public void postTweet(int id) {
            tweets.addLast(new Tweet(id));
        }

        public void follow(int userid) {
            if (userid == this.id)
                return;
            if (this.follows.contains(userid))
                return;
            follows.addLast(userid);
        }

        public void unfollow(int userid) {
            if (follows.contains(userid) && this.id != userid)
                follows.removeFirstOccurrence(userid);
        }
    }

    private Map<Integer, User> users;

    public static long timestap = 0;

    private User getUser(int userId) {
        if (!users.containsKey(userId)) {
            users.put(userId, new User(userId));
        }
        return users.get(userId);
    }

    /** Initialize your data structure here. */
    public Twitter() {
        users = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        User u = getUser(userId);
        u.postTweet(tweetId);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in
     * the news feed must be posted by users who the user followed or by the user
     * herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        // 拿到用户
        // 获取用户关注的人；
        // 将这些人的tweets按照从小到大排序
        LinkedList<Tweet> res = new LinkedList<>();
        User u = getUser(userId);
        for (Tweet t : u.tweets) {
            res.add(t);
        }
        for (Integer n : u.follows) {
            for (Tweet t : getUser(n).tweets) {
                res.add(t);
            }
        }
        Collections.sort(res, (t1, t2) -> {
            if (t1.timestamp < t2.timestamp)
                return 1;
            else
                return -1;
        });
        int cnt = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (Tweet t : res) {
            if (cnt >= 10)
                break;
            list.add(t.id);
            cnt++;
        }
        return list;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a
     * no-op.
     */
    public void follow(int followerId, int followeeId) {
        User u = getUser(followerId);
        u.follow(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a
     * no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        User u = getUser(followerId);
        u.unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such: Twitter obj =
 * new Twitter(); obj.postTweet(userId,tweetId); List<Integer> param_2 =
 * obj.getNewsFeed(userId); obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 **/