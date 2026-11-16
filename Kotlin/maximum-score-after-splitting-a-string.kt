package maximumscoreaftersplittingastring

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxScore(s: String): Int {
        var result = 0
        var zeros = 0
        var ones = 0
        for (i in 1 until s.length - 1) {
            if (s[i] == '0') {
                zeros++
            } else {
                ones++
            }
            result = maxOf(result, zeros - ones)
        }
        return result + ones + (if (s.first() == '0') 1 else 0) + (if (s.last() == '1') 1 else 0)
    }
}
