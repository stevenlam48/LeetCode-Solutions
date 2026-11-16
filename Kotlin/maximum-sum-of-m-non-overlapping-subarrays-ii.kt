package maximumsumofmnonoverlappingsubarraysii
// Time:  O(nlogr)
// Space: O(n)

class Solution {
    fun maximumSum(nums: IntArray, m: Int, l: Int, r: Int): Long {
        val n = nums.size
        val prefix = LongArray(n + 1)
        for (i in 0 until n) {
            prefix[i + 1] = prefix[i] + nums[i]
        }

        fun bestSingle(): Long {
            var result = Long.MIN_VALUE
            val dq = java.util.ArrayDeque<Int>()
            for (i in 1..n) {
                val j = i - l
                if (j >= 0) {
                    while (dq.isNotEmpty() && prefix[dq.peekLast()] >= prefix[j]) {
                        dq.pollLast()
                    }
                    dq.addLast(j)
                }
                while (dq.isNotEmpty() && dq.peekFirst() < i - r) {
                    dq.pollFirst()
                }
                if (dq.isNotEmpty()) {
                    result = maxOf(result, prefix[i] - prefix[dq.peekFirst()])
                }
            }
            return result
        }

        fun better(v1: Long, c1: Int, v2: Long, c2: Int): Boolean {
            return v1 > v2 || (v1 == v2 && c1 < c2)
        }

        fun f(x: Long): Pair<Long, Int> {
            val dpVal = LongArray(n + 1)
            val dpCnt = IntArray(n + 1)
            val dq = java.util.ArrayDeque<Int>()
            for (i in 1..n) {
                val j = i - l
                if (j >= 0) {
                    while (dq.isNotEmpty() && better(
                            dpVal[j] - prefix[j], dpCnt[j],
                            dpVal[dq.peekLast()] - prefix[dq.peekLast()], dpCnt[dq.peekLast()]
                        )
                    ) {
                        dq.pollLast()
                    }
                    dq.addLast(j)
                }
                while (dq.isNotEmpty() && dq.peekFirst() < i - r) {
                    dq.pollFirst()
                }
                dpVal[i] = dpVal[i - 1]
                dpCnt[i] = dpCnt[i - 1]
                if (dq.isNotEmpty()) {
                    val newVal = (dpVal[dq.peekFirst()] - prefix[dq.peekFirst()]) + prefix[i] - x
                    val newCnt = dpCnt[dq.peekFirst()] + 1
                    if (better(newVal, newCnt, dpVal[i], dpCnt[i])) {
                        dpVal[i] = newVal
                        dpCnt[i] = newCnt
                    }
                }
            }
            return dpVal[n] to dpCnt[n]
        }

        val single = bestSingle()
        val first = f(0)
        if (first.second == 0) {
            return single
        }
        if (first.second <= m) {
            return first.first
        }
        val mx = single
        var lo = 1L
        var hi = mx
        while (lo <= hi) {
            val mid = lo + (hi - lo) / 2
            if (f(mid).second <= m) {
                hi = mid - 1
            } else {
                lo = mid + 1
            }
        }
        val x = lo
        return f(x).first + m.toLong() * x
    }
}
