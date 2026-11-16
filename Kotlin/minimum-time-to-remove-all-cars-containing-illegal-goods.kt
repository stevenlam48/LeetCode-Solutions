package minimumtimetoremoveallcarscontainingillegalgoods

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minimumTime(s: String): Int {
        var left = 0
        var result = s.length
        for (i in 1..s.length) {
            left = minOf(left + if (s[i - 1] == '1') 2 else 0, i)
            result = minOf(result, left + s.length - i)
        }
        return result
    }
}
