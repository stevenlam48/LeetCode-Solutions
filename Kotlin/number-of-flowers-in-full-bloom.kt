package numberofflowersinfullbloom

// Time:  O(nlogn + mlogn)
// Space: O(n)

// line sweep, binary search
class Solution {
    fun fullBloomFlowers(flowers: Array<IntArray>, persons: IntArray): IntArray {
        val cnt = java.util.TreeMap<Int, Int>()
        for (flower in flowers) {
            cnt[flower[0]] = (cnt[flower[0]] ?: 0) + 1
            cnt[flower[1] + 1] = (cnt[flower[1] + 1] ?: 0) - 1
        }
        val prefix = ArrayList<Int>()
        prefix.add(0)
        val events = ArrayList<Int>()
        for ((k, v) in cnt) {
            events.add(k)
            prefix.add(prefix.last() + v)
        }
        val result = IntArray(persons.size)
        for (idx in persons.indices) {
            val t = persons[idx]
            var lo = 0
            var hi = events.size
            while (lo < hi) {
                val mid = (lo + hi) ushr 1
                if (events[mid] <= t) {
                    lo = mid + 1
                } else {
                    hi = mid
                }
            }
            result[idx] = prefix[lo]
        }
        return result
    }
}
