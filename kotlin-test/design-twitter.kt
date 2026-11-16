package designtwitter

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class DesignTwitterTest {
    @Test
    fun testExample() {
        val twitter = Twitter()
        twitter.postTweet(1, 5)
        assertArrayEquals(intArrayOf(5), twitter.getNewsFeed(1))
        twitter.follow(1, 2)
        twitter.postTweet(2, 6)
        assertArrayEquals(intArrayOf(6, 5), twitter.getNewsFeed(1))
        twitter.unfollow(1, 2)
        assertArrayEquals(intArrayOf(5), twitter.getNewsFeed(1))
    }

    @Test
    fun testLimitToTenMostRecent() {
        val twitter = Twitter()
        for (i in 1..12) {
            twitter.postTweet(1, i)
        }
        assertArrayEquals(intArrayOf(12, 11, 10, 9, 8, 7, 6, 5, 4, 3), twitter.getNewsFeed(1))
    }

    @Test
    fun testMergedOrdering() {
        val twitter = Twitter()
        twitter.postTweet(1, 1)
        twitter.postTweet(2, 2)
        twitter.follow(1, 2)
        twitter.postTweet(1, 3)
        assertArrayEquals(intArrayOf(3, 2, 1), twitter.getNewsFeed(1))
    }

    @Test
    fun testFollowSelfIsNoOp() {
        val twitter = Twitter()
        twitter.postTweet(1, 5)
        twitter.follow(1, 1)
        assertArrayEquals(intArrayOf(5), twitter.getNewsFeed(1))
    }

    @Test
    fun testUnfollowNonFollowed() {
        val twitter = Twitter()
        twitter.postTweet(2, 9)
        twitter.unfollow(1, 2)
        assertArrayEquals(intArrayOf(), twitter.getNewsFeed(1))
    }

    @Test
    fun testEmptyFeed() {
        val twitter = Twitter()
        assertArrayEquals(intArrayOf(), twitter.getNewsFeed(123))
    }
}
