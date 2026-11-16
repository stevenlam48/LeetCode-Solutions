package selldiminishingvaluedcoloredballs

// Time:  O(nlogm), m is the max of inventory, n is the size of inventory
// Space: O(1)

class Solution {
    fun maxProfit(inventory: IntArray, orders: Int): Int {
        val mod = 1_000_000_007
        var left = 1
        var right = inventory.maxOrNull()!!
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (!check(inventory, orders, mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        var result = 0L
        for (cnt in inventory) {
            if (cnt >= left) {
                result = (result + (left + cnt).toLong() * (cnt - left + 1) / 2 % mod) % mod
            }
        }
        return ((result + (left - 1).toLong() * (orders - count(inventory, left)) % mod) % mod).toInt()
    }

    private fun count(inventory: IntArray, x: Int): Int {
        val maxOrders = 1_000_000_000
        var result = 0
        for (cnt in inventory) {
            if (cnt >= x) {
                if (result >= (maxOrders + 1) - (cnt - x + 1)) {
                    result = maxOrders + 1
                    break
                }
                result += cnt - x + 1
            }
        }
        return result
    }

    private fun check(inventory: IntArray, orders: Int, x: Int): Boolean {
        return count(inventory, x) > orders
    }
}
