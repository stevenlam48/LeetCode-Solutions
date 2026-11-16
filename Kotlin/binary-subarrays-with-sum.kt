package binarysubarrayswithsum

// Time:  O(n)
// Space: O(1)
class Solution {
    fun numSubarraysWithSum(a: IntArray, s: Int): Int {
        var result = 0
        var left = 0
        var right = 0
        var sumLeft = 0
        var sumRight = 0
        for (i in a.indices) {
            sumLeft += a[i]
            while (left < i && sumLeft > s) {
                sumLeft -= a[left]
                ++left
            }
            sumRight += a[i]
            while (right < i && (sumRight > s || (sumRight == s && a[right] == 0))) {
                sumRight -= a[right]
                ++right
            }
            if (sumLeft == s) {
                result += right - left + 1
            }
        }
        return result
    }
}
