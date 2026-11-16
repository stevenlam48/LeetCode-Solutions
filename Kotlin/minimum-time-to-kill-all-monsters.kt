package minimumtimetokillallmonsters

// Time:  O(n * 2^n)
// Space: O(2^n)

class Solution {
    fun minimumTime(power: IntArray): Long {
        var dp = hashMapOf(0 to 0L)
        for (gain in 1..power.size) {
            val next = HashMap<Int, Long>()
            for ((mask, value) in dp) {
                for (i in power.indices) {
                    if (mask and (1 shl i) != 0) {
                        continue
                    }
                    val time = value + (power[i] + gain - 1) / gain
                    val newMask = mask or (1 shl i)
                    if (!next.containsKey(newMask) || next[newMask]!! > time) {
                        next[newMask] = time
                    }
                }
            }
            dp = next
        }
        return dp[(1 shl power.size) - 1]!!
    }
}
