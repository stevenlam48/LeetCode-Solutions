package partitionstringintosubstringswithvaluesatmostk

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minimumPartition(s: String, k: Int): Int {
        var result = 1
        var curr = 0L
        for (c in s) {
            if (c - '0' > k) {
                return -1
            }
            if (curr * 10 + (c - '0') > k) {
                ++result
                curr = 0
            }
            curr = curr * 10 + (c - '0')
        }
        return result
    }
}
