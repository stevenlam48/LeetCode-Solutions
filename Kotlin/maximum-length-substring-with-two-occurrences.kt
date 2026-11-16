package maximumlengthsubstringwithtwooccurrences

// Time:  O(n + 26)
// Space: O(26)

class Solution {
    fun maximumLengthSubstring(s: String): Int {
        val count = 2
        val frequencies = IntArray(26)
        var left = 0
        var invalidCount = 0
        for (right in s.indices) {
            val rightIndex = s[right] - 'a'
            if (frequencies[rightIndex] == count) {
                invalidCount++
            }
            frequencies[rightIndex]++
            if (invalidCount != 0) {
                val leftIndex = s[left] - 'a'
                frequencies[leftIndex]--
                if (frequencies[leftIndex] == count) {
                    invalidCount--
                }
                left++
            }
        }
        return s.length - left
    }
}
