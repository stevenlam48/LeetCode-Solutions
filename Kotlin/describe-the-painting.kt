package describethepainting

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun splitPainting(segments: Array<IntArray>): Array<LongArray> {
        val counts = HashMap<Int, Long>()
        for (s in segments) {
            counts[s[0]] = (counts[s[0]] ?: 0L) + s[2]
            counts[s[1]] = (counts[s[1]] ?: 0L) - s[2]
        }
        val points = counts.entries.sortedBy { it.key }

        val result = mutableListOf<LongArray>()
        var overlap = 0L
        var prev = 0
        for ((curr, cnt) in points) {
            if (overlap != 0L) {
                result.add(longArrayOf(prev.toLong(), curr.toLong(), overlap))
            }
            overlap += cnt
            prev = curr
        }
        return result.toTypedArray()
    }
}
