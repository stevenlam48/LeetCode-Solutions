package minimumchangestomakealternatingbinarystring

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minOperations(s: String): Int {
        var count = 0
        for (i in s.indices) {
            if (s[i] - '0' == i % 2) {
                ++count
            }
        }
        return minOf(count, s.length - count)
    }
}
