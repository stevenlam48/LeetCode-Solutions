package minimumpossiblemaximumwaitingtime
// Time:  O(n * rlogr * (f / 64)) = O(n * rlogr), r = max(demand), f = fuel[0]
// Space: O(r * (f / 64)) = O(r)

class Solution {
    fun minMaxWaitingTime(demand: IntArray, fuel: IntArray): Int {
        fun low(x: Int): Long = when {
            x >= 63 -> -1L
            x >= 0 -> (1L shl (x + 1)) - 1L
            else -> 0L
        }

        fun high(x: Int): Long = -1L xor low(x - 1)

        fun findMaxServed(): Int {
            var mask = 1L
            var total = 0
            for (i in demand.indices) {
                mask = ((mask shl demand[i]) and low(fuel[0])) or
                    (mask and high(total + demand[i] - fuel[1]))
                if (mask == 0L) {
                    return i
                }
                total += demand[i]
            }
            return demand.size
        }

        val l = findMaxServed()
        if (l == 0) {
            return -1
        }

        val mx = demand.max()
        fun check(w: Int): Boolean {
            var dp = Array(2) { LongArray(mx + 1) }
            dp[0][0] = 1L
            var total = 0
            for (i in 0 until l) {
                val newDp = Array(2) { LongArray(mx + 1) }
                fun update(last: Int, gap: Int, initialMask: Long) {
                    var mask = initialMask
                    if (last == 0) {
                        mask = (mask shl demand[i]) and low(fuel[0])
                    } else {
                        mask = mask and high(total + demand[i] - fuel[1])
                    }
                    newDp[last][gap] = newDp[last][gap] or mask
                }

                for (last in dp.indices) {
                    for (gap in dp[0].indices) {
                        if (dp[last][gap] == 0L) {
                            continue
                        }
                        val previous = if (i - 1 >= 0) demand[i - 1] else 0
                        if (previous <= w) {
                            update(last, maxOf(gap - previous, 0), dp[last][gap])
                        }
                        if (gap <= w) {
                            update(last xor 1, maxOf(previous - gap, 0), dp[last][gap])
                        }
                    }
                }
                dp = newDp
                total += demand[i]
            }
            return dp.any { row -> row.any { mask -> mask != 0L } }
        }

        var left = 0
        var right = mx
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
