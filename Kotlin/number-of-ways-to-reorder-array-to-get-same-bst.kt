package numberofwaystoreorderarraytogetsamebst

// Time:  O(n^2)
// Space: O(n^2)

private val dp = Array(1000) { IntArray(1000) }

class Solution {
    fun numOfWays(nums: IntArray): Int {
        if (dp[0][0] == 0) {
            for (i in dp.indices) {
                dp[i][0] = 1
                for (j in 1..i) {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % mod
                }
            }
        }
        return ((iterDfs(nums) - 1) % mod + mod) % mod
    }

    private fun iterDfs(nums: IntArray): Int {
        val result = IntArray(1)
        val stack = ArrayDeque<StackItem>()
        stack.addLast(StackItem(1, nums.copyOf(), null, null, result))
        while (stack.isNotEmpty()) {
            val item = stack.removeLast()
            if (item.step == 1) {
                val current = item.nums!!
                if (current.size <= 2) {
                    item.ret[0] = 1
                    continue
                }
                val left = mutableListOf<Int>()
                val right = mutableListOf<Int>()
                for (i in 1 until current.size) {
                    if (current[i] < current[0]) {
                        left.add(current[i])
                    } else {
                        right.add(current[i])
                    }
                }
                val ret1 = IntArray(1)
                val ret2 = IntArray(1)
                item.ret[0] = dp[left.size + right.size][left.size]
                stack.addLast(StackItem(2, null, ret1, ret2, item.ret))
                stack.addLast(StackItem(1, right.toIntArray(), null, null, ret2))
                stack.addLast(StackItem(1, left.toIntArray(), null, null, ret1))
            } else if (item.step == 2) {
                item.ret[0] = (item.ret[0].toLong() * item.ret1!![0] % mod).toInt()
                item.ret[0] = (item.ret[0].toLong() * item.ret2!![0] % mod).toInt()
            }
        }
        return result[0]
    }

    private data class StackItem(
        val step: Int,
        val nums: IntArray?,
        val ret1: IntArray?,
        val ret2: IntArray?,
        val ret: IntArray
    )

    private val mod = 1_000_000_007
}
