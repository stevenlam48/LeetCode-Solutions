package detectpatternoflengthmrepeatedkormoretimes

// Time:  O(n)
// Space: O(1)

class Solution {
    fun containsPattern(arr: IntArray, m: Int, k: Int): Boolean {
        var count = 0
        for (i in 0 until arr.size - m) {
            if (arr[i] != arr[i + m]) {
                count = 0
                continue
            }
            if (++count == (k - 1) * m) {
                return true
            }
        }
        return false
    }
}
