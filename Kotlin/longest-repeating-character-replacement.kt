package longestrepeatingcharacterreplacement

// Time:  O(n)
// Space: O(1)

class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        var result = 0
        var maxCount = 0
        val count = HashMap<Char, Int>()
        for (i in s.indices) {
            count[s[i]] = (count[s[i]] ?: 0) + 1
            maxCount = maxOf(maxCount, count[s[i]]!!)
            if (result - maxCount >= k) {
                count[s[i - result]] = count[s[i - result]]!! - 1
            } else {
                ++result
            }
        }
        return result
    }
}
