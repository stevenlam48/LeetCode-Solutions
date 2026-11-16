package minimumbitwiseorfromgrid

// Time:  O(nlogr), r = max(nums)
// Space: O(1)

class Solution {
    fun minimumOR(grid: Array<IntArray>): Int {
        var maximum = 0
        for (row in grid) {
            for (x in row) {
                maximum = maxOf(maximum, x)
            }
        }
        var result = 0
        for (i in 31 - maximum.countLeadingZeroBits() downTo 0) {
            if (grid.any { row ->
                    row.all { x -> x and (result or ((1 shl i) - 1)) != x }
                }) {
                result = result or (1 shl i)
            }
        }
        return result
    }
}
