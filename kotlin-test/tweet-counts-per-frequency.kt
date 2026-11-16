package tweetcountsperfrequency

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class TweetCountsPerFrequencyTest {
    @Test
    fun fullLeetCodeOperationSequence() {
        val counts = TweetCounts()
        counts.recordTweet("tweet3", 0)
        counts.recordTweet("tweet3", 60)
        counts.recordTweet("tweet3", 10)
        assertArrayEquals(intArrayOf(2), counts.getTweetCountsPerFrequency("minute", "tweet3", 0, 59))
        assertArrayEquals(intArrayOf(2, 1), counts.getTweetCountsPerFrequency("minute", "tweet3", 0, 60))
        assertArrayEquals(intArrayOf(3), counts.getTweetCountsPerFrequency("hour", "tweet3", 0, 210))
        counts.recordTweet("tweet3", 120)
        assertArrayEquals(intArrayOf(4), counts.getTweetCountsPerFrequency("hour", "tweet3", 0, 210))
        assertArrayEquals(intArrayOf(1), counts.getTweetCountsPerFrequency("minute", "tweet3", 100, 120))
    }

    @Test
    fun duplicateTweetsAndPartialBuckets() {
        val counts = TweetCounts()
        repeat(3) { counts.recordTweet("a", 5) }
        counts.recordTweet("a", 65)
        assertArrayEquals(intArrayOf(3, 1), counts.getTweetCountsPerFrequency("minute", "a", 0, 70))
        assertArrayEquals(intArrayOf(1, 0), counts.getTweetCountsPerFrequency("minute", "a", 10, 70))
    }

    @Test
    fun independentNamesAndEmptyResults() {
        val counts = TweetCounts()
        counts.recordTweet("a", 1)
        counts.recordTweet("b", 2)
        assertArrayEquals(intArrayOf(1), counts.getTweetCountsPerFrequency("day", "a", 0, 100))
        assertArrayEquals(intArrayOf(0), counts.getTweetCountsPerFrequency("day", "missing", 0, 100))
        assertArrayEquals(intArrayOf(0, 0), counts.getTweetCountsPerFrequency("hour", "a", 3600, 7200))
    }
}
