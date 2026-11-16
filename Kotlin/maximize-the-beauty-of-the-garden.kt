package maximizethebeautyofthegarden

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maximumBeauty(flowers: IntArray): Int {
        val lookup = HashMap<Int, Int>()
        val prefix = IntArray(flowers.size + 1)
        var result = Int.MIN_VALUE
        for (i in flowers.indices) {
            prefix[i + 1] = if (flowers[i] > 0) prefix[i] + flowers[i] else prefix[i]
            if (!lookup.containsKey(flowers[i])) {
                lookup[flowers[i]] = i
                continue
            }
            val left = lookup[flowers[i]]!!
            result = maxOf(
                result,
                if (flowers[i] < 0) 2 * flowers[i] + prefix[i + 1] - prefix[left]
                else prefix[i + 1] - prefix[left]
            )
        }
        return result
    }
}
