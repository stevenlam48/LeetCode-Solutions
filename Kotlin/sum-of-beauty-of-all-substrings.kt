package sumofbeautyofallsubstrings

// Time:  O(n^2)
// Space: O(1)
class Solution {
    fun beautySum(s: String): Int {
        var result = 0
        for (i in s.indices) {
            val lookup = IntArray(26)
            for (j in i until s.length) {
                ++lookup[s[j] - 'a']
                var maximum = 0
                var minimum = Int.MAX_VALUE
                for (value in lookup) {
                    maximum = maxOf(maximum, value)
                    if (value != 0) {
                        minimum = minOf(minimum, value)
                    }
                }
                result += maximum - minimum
            }
        }
        return result
    }
}
