package minimizedmaximumofproductsdistributedtoanystore

// Time:  O(nlogm), m is the max of quantities
// Space: O(1)

class Solution {
    fun minimizedMaximum(n: Int, quantities: IntArray): Int {
        var left = 1
        var right = quantities.max()
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (check(n, quantities, mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left
    }

    private fun check(n: Int, quantities: IntArray, x: Int): Boolean {
        var total = 0
        for (q in quantities) {
            total += (q + (x - 1)) / x
        }
        return total <= n
    }
}
