package tweetcountsperfrequency
// Time:  add:   O(logn),
//        query: O(c), c is the total count of matching records
// Space: O(n)

import java.util.TreeMap

class TweetCounts {
    private val records = HashMap<String, TreeMap<Int, Int>>()

    fun recordTweet(tweetName: String, time: Int) {
        val times = records.getOrPut(tweetName) { TreeMap() }
        times[time] = times.getOrDefault(time, 0) + 1
    }

    fun getTweetCountsPerFrequency(freq: String, tweetName: String, startTime: Int, endTime: Int): IntArray {
        val delta = when (freq) {
            "minute" -> 60
            "hour" -> 3600
            "day" -> 86400
            else -> throw IllegalArgumentException(freq)
        }
        val result = IntArray((endTime - startTime) / delta + 1)
        val times = records.getOrPut(tweetName) { TreeMap() }
        for ((time, count) in times.tailMap(startTime, true)) {
            if (time > endTime) {
                break
            }
            result[(time - startTime) / delta] += count
        }
        return result
    }
}
