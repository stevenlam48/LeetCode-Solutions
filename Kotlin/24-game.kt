package p24game

import kotlin.math.abs

// Time:  O(n^3 * 4^n) = O(1), n = 4
// Space: O(n^2) = O(1)

class Solution {
    fun judgePoint24(nums: IntArray): Boolean {
        val doubles = DoubleArray(nums.size) { nums[it].toDouble() }
        return dfs(doubles)
    }

    private fun dfs(nums: DoubleArray): Boolean {
        if (nums.size == 1) {
            return abs(nums[0] - 24) < 1e-6
        }
        for (i in nums.indices) {
            for (j in nums.indices) {
                if (i == j) {
                    continue
                }
                val nextNums = ArrayList<Double>(nums.size)
                for (k in nums.indices) {
                    if (k == i || k == j) {
                        continue
                    }
                    nextNums.add(nums[k])
                }
                for (op in OPS) {
                    if (((op == '+' || op == '*') && i > j) ||
                        (op == '/' && nums[j] == 0.0)
                    ) {
                        continue
                    }
                    nextNums.add(apply(op, nums[i], nums[j]))
                    if (dfs(nextNums.toDoubleArray())) {
                        return true
                    }
                    nextNums.removeAt(nextNums.size - 1)
                }
            }
        }
        return false
    }

    private fun apply(op: Char, a: Double, b: Double): Double = when (op) {
        '+' -> a + b
        '-' -> a - b
        '*' -> a * b
        else -> a / b
    }

    private companion object {
        val OPS = charArrayOf('+', '-', '*', '/')
    }
}
