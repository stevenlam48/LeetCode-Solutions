package getequalsubstringswithinbudget

// Time:  O(n)
// Space: O(1)

import kotlin.math.abs

class Solution {
    fun equalSubstring(s: String, t: String, maxCost: Int): Int {
        var remainingCost = maxCost
        var left = 0
        var right = 0
        while (right < s.length) {
            remainingCost -= abs(s[right] - t[right])
            if (remainingCost < 0) {
                remainingCost += abs(s[left] - t[left])
                left++
            }
            right++
        }
        return right - left
    }
}
