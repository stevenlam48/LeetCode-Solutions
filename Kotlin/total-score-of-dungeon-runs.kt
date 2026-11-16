package totalscoreofdungeonruns

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun totalScore(hp: Int, damage: IntArray, requirement: IntArray): Long {
        val prefix = LongArray(damage.size + 1)
        for (i in 0 until damage.size) {
            prefix[i + 1] = prefix[i] + damage[i]
        }
        var result = 0L
        for (i in damage.indices) {
            val target = prefix[i + 1] + requirement[i] - hp
            var lo = 0
            var hi = prefix.size
            while (lo < hi) {
                val mid = (lo + hi) ushr 1
                if (prefix[mid] < target) {
                    lo = mid + 1
                } else {
                    hi = mid
                }
            }
            val j = lo
            if (j <= i) {
                result += i - j + 1
            }
        }
        return result
    }
}
