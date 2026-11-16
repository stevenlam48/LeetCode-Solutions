package minimumoperationstomakenumbersnonpositive

// Time:  O(nlogr)
// Space: O(1)

// binary search, greedy
class Solution {
    fun minOperations(nums: IntArray, x: Int, y: Int): Int {
        fun ceilDivide(a: Int, b: Int): Int = (a + b - 1) / b

        fun check(total: Int): Boolean {
            var sum = 0L
            for (v in nums) {
                val times = minOf(ceilDivide(v, y), total)
                sum += ceilDivide(maxOf(v - times * y, 0), x - y).toLong()
            }
            return sum <= total
        }

        var left = 1
        var right = ceilDivide(nums.max(), y)
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (check(mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left
    }
}
