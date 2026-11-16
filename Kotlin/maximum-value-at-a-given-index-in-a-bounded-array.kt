package maximumvalueatagivenindexinaboundedarray

// Time:  O(logm)
// Space: O(1)

class Solution {
    fun maxValue(n: Int, index: Int, maxSum: Int): Int {
        val available = maxSum - n
        fun check(x: Int): Boolean {
            var y = maxOf(x - index, 0).toLong()
            var total = (x + y) * (x - y + 1) / 2
            y = maxOf(x - (n - 1 - index), 0).toLong()
            total += (x + y) * (x - y + 1) / 2
            return total - x <= available
        }
        var left = 0
        var right = available
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (!check(mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return 1 + right
    }
}
