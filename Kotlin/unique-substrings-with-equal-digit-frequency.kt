package uniquesubstringswithequaldigitfrequency

// Time:  O(n^2)
// Space: O(n^2)

class Solution {
    fun equalDigitFrequency(s: String): Int {
        val mod = 1_000_000_007
        val d = 27
        val lookup = HashSet<Int>()
        for (i in s.indices) {
            val count = HashMap<Int, Int>()
            var h = 0L
            var maxCount = 0
            for (j in i until s.length) {
                val digit = s[j] - '0' + 1
                h = (h * d + digit) % mod
                count[digit] = (count[digit] ?: 0) + 1
                maxCount = maxOf(maxCount, count[digit]!!)
                if (count.size * maxCount == j - i + 1) {
                    lookup.add(h.toInt())
                }
            }
        }
        return lookup.size
    }
}
