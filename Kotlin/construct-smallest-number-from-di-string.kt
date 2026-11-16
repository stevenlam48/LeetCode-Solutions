package constructsmallestnumberfromdistring

// Time:  O(n)
// Space: O(1)

// constructive algorithms
class Solution {
    fun smallestNumber(pattern: String): String {
        val result = StringBuilder()
        for (i in 0..pattern.length) {
            if (!(i == pattern.length || pattern[i] == 'I')) {
                continue
            }
            val start = result.length + 1
            for (j in i + 1 downTo start) {
                result.append(('0' + j))
            }
        }
        return result.toString()
    }
}
