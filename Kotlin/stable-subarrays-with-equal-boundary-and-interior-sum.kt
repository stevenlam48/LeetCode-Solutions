package stablesubarrayswithequalboundaryandinteriorsum

// Time:  O(n)
// Space: O(n)

class Solution {
    fun countStableSubarrays(capacity: IntArray): Long {
        val L = 3

        var result = 0L
        val cnt = HashMap<Int, HashMap<Long, Int>>()
        var i = 0L
        var prefix = 0L
        var prefix2 = 0L
        while (i < capacity.size) {
            val inner = cnt.getOrPut(capacity[i.toInt()]) { HashMap() }
            result += inner.getOrDefault(prefix - capacity[i.toInt()], 0)
            prefix += capacity[i.toInt()]
            if ((i + 1) - L + 1 >= 0) {
                prefix2 += capacity[((i + 1) - L + 1).toInt()]
                val key = capacity[((i + 1) - L + 1).toInt()]
                val m = cnt.getOrPut(key) { HashMap() }
                m[prefix2] = m.getOrDefault(prefix2, 0) + 1
            }
            ++i
        }
        return result
    }
}
