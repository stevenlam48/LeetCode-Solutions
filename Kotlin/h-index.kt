package hindex

// Time:  O(n)
// Space: O(n)

// Counting sort.
class Solution {
    fun hIndex(citations: IntArray): Int {
        val n = citations.size
        val count = IntArray(n + 1)
        for (x in citations) {
            // Put all x >= n in the same bucket.
            if (x >= n) {
                ++count[n]
            } else {
                ++count[x]
            }
        }

        var h = 0
        for (i in n downTo 0) {
            h += count[i]
            if (h >= i) {
                return i
            }
        }
        return h
    }
}
