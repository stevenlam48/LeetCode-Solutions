package maximumcandiesallocatedtokchildren

// Time:  O(nlogr), r is max(candies)
// Space: O(1)

class Solution {
    fun maximumCandies(candies: IntArray, k: Long): Int {
        fun check(x: Int): Boolean {
            var total = 0L
            for (v in candies) {
                total += v / x
            }
            return total >= k
        }

        var left = 1
        var right = candies.max()
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (!check(mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return right
    }
}
