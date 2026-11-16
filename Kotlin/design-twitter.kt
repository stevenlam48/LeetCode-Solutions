package designtwitter

import java.util.PriorityQueue

// Time:  O(u + klogk), k is most recently number of tweets,
//                      u is the number of the user's following.
// Space: O(t + f), t is the total number of tweets,
//                  f is the total number of followings.

class Twitter {
    private val number_of_most_recent_tweets = 10
    private val followings = HashMap<Int, HashSet<Int>>()
    private val messages = HashMap<Int, MutableList<Pair<Long, Int>>>()
    private var time = 0L

    fun postTweet(userId: Int, tweetId: Int) {
        messages.getOrPut(userId) { ArrayList() }.add(Pair(++time, tweetId))
    }

    fun getNewsFeed(userId: Int): IntArray {
        val heap = PriorityQueue<Cursor>(compareByDescending<Cursor> { it.time })
        val users = HashSet<Int>(followings[userId] ?: emptySet<Int>())
        users.add(userId)
        for (id in users) {
            val msgs = messages[id]
            if (msgs != null && msgs.isNotEmpty()) {
                heap.add(Cursor(msgs.last().first, id, msgs.size - 1))
            }
        }
        val res = ArrayList<Int>()
        while (heap.isNotEmpty() && res.size < number_of_most_recent_tweets) {
            val c = heap.poll()
            val msgs = messages[c.userId]!!
            res.add(msgs[c.index].second)
            if (c.index > 0) {
                heap.add(Cursor(msgs[c.index - 1].first, c.userId, c.index - 1))
            }
        }
        return res.toIntArray()
    }

    fun follow(followerId: Int, followeeId: Int) {
        if (followerId != followeeId) {
            followings.getOrPut(followerId) { HashSet() }.add(followeeId)
        }
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        followings[followerId]?.remove(followeeId)
    }

    private data class Cursor(val time: Long, val userId: Int, val index: Int)
}
