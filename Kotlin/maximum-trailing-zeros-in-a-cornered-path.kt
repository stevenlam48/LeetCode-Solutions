package maximumtrailingzerosinacorneredpath

// Time:  O(m * n)
// Space: O(m * n)

class Solution {
    fun maxTrailingZeros(grid: Array<IntArray>): Int {
        fun factor(value: Int): IntArray {
            var x = value
            val primes = intArrayOf(2, 5)
            val count = IntArray(2)
            for (i in primes.indices) {
                while (x != 0 && x % primes[i] == 0) {
                    x /= primes[i]
                    ++count[i]
                }
            }
            return count
        }
        fun add(a: IntArray, b: IntArray): IntArray = intArrayOf(a[0] + b[0], a[1] + b[1])
        fun subtract(a: IntArray, b: IntArray): IntArray = intArrayOf(a[0] - b[0], a[1] - b[1])
        fun count(a: IntArray): Int = minOf(a[0], a[1])

        val left = Array(grid.size) { Array(grid[0].size) { IntArray(2) } }
        for (i in grid.indices) {
            left[i][0] = factor(grid[i][0])
            for (j in 1 until grid[0].size) {
                left[i][j] = add(left[i][j - 1], factor(grid[i][j]))
            }
        }
        var result = 0
        for (j in grid[0].indices) {
            var total = IntArray(2)
            for (i in grid.indices) {
                total = add(total, factor(grid[i][j]))
            }
            var up = IntArray(2)
            for (i in grid.indices) {
                val right = if (j != 0) subtract(left[i].last(), left[i][j - 1]) else left[i].last()
                result = maxOf(result, count(add(left[i][j], up)), count(add(right, up)))
                up = add(up, factor(grid[i][j]))
                val down = subtract(total, up)
                result = maxOf(result, count(add(left[i][j], down)), count(add(right, down)))
            }
        }
        return result
    }
}
