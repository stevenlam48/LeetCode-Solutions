package distringmatch

// Time:  O(n)
// Space: O(1)

class Solution {
    fun diStringMatch(s: String): IntArray {
        val result = IntArray(s.length + 1)
        var left = 0
        var right = s.length
        for (i in s.indices) {
            if (s[i] == 'I') {
                result[i] = left++
            } else {
                result[i] = right--
            }
        }
        result[s.length] = left
        return result
    }
}
