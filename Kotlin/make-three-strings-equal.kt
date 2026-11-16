package makethreestringsequal

// Time:  O(n)
// Space: O(1)

// string
class Solution {
    fun findMinimumOperations(s1: String, s2: String, s3: String): Int {
        val n = minOf(s1.length, s2.length, s3.length)
        var i = 0
        while (i < n) {
            if (s1[i] != s2[i] || s2[i] != s3[i]) {
                break
            }
            ++i
        }
        return if (i > 0) s1.length + s2.length + s3.length - 3 * i else -1
    }
}
