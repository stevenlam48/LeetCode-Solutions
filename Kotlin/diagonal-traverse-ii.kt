package diagonaltraverseii

import java.util.ArrayDeque

// Time:  O(m * n)
// Space: O(m)

class Solution {
    fun findDiagonalOrder(nums: Array<IntArray>): IntArray {
        val n = nums.maxOfOrNull { it.size } ?: 0
        val result = mutableListOf<Int>()
        var dq = ArrayDeque<Pair<Int, Int>>()
        for (r in 0 until nums.size + n - 1) {
            val newDq = ArrayDeque<Pair<Int, Int>>()
            if (r < nums.size) {
                dq.addFirst(Pair(r, 0))
            }
            for ((row, col) in dq) {
                result.add(nums[row][col])
                if (col + 1 < nums[row].size) {
                    newDq.addLast(Pair(row, col + 1))
                }
            }
            dq = newDq
        }
        return result.toIntArray()
    }
}
