package substringsofsizethreewithdistinctcharacters

// Time:  O(n)
// Space: O(1)
class Solution {
    fun countGoodSubstrings(s: String): Int {
        val k = 3
        var result = 0
        val count = HashMap<Char, Int>()
        for (i in s.indices) {
            if (i >= k) {
                val remaining = count.getValue(s[i - k]) - 1
                if (remaining == 0) {
                    count.remove(s[i - k])
                } else {
                    count[s[i - k]] = remaining
                }
            }
            count[s[i]] = count.getOrDefault(s[i], 0) + 1
            if (count.size == k) {
                ++result
            }
        }
        return result
    }
}
