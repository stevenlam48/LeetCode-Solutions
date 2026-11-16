package kokoeatingbananas

// Time:  O(nlogr)
// Space: O(1)

class Solution {
    fun minEatingSpeed(piles: IntArray, H: Int): Int {
        var left = 1
        var right = piles.maxOrNull()!!
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (possible(piles, H, mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left
    }

    private fun possible(piles: IntArray, H: Int, K: Int): Boolean {
        var time = 0
        for (pile in piles) {
            time += (pile - 1) / K + 1
        }
        return time <= H
    }
}
