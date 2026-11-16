package minimumcosttomergesortedlists
// Time:  O(l * nlogn + 2^n * log(n * l) * n * logl + 3^n), n = len(lists), l = max(len(list) for list in lists)
// Space: O(n * l + 2^n)

import java.util.PriorityQueue
import kotlin.math.abs

class Solution {
    fun minMergeCost(lists: List<IntArray>): Long {
        fun merge(): IntArray {
            val minHeap = PriorityQueue<Triple<Int, Int, Int>>(
                compareBy<Triple<Int, Int, Int>> { it.first }.thenBy { it.second }.thenBy { it.third }
            )
            for (i in lists.indices) {
                minHeap.add(Triple(lists[i][0], i, 0))
            }
            val result = ArrayList<Int>()
            while (minHeap.isNotEmpty()) {
                val (x, i, j) = minHeap.poll()
                result.add(x)
                if (j + 1 < lists[i].size) {
                    minHeap.add(Triple(lists[i][j + 1], i, j + 1))
                }
            }
            return result.toIntArray()
        }

        fun upperBound(list: IntArray, value: Int): Int {
            var left = 0
            var right = list.size
            while (left < right) {
                val mid = left + (right - left) / 2
                if (list[mid] <= value) {
                    left = mid + 1
                } else {
                    right = mid
                }
            }
            return left
        }

        val dp1 = IntArray(1 shl lists.size)
        for (i in lists.indices) {
            dp1[1 shl i] = lists[i].size
        }
        for (mask in 1 until dp1.size) {
            dp1[mask] = dp1[mask xor (mask and -mask)] + dp1[mask and -mask]
        }
        val sortedVals = merge().distinct().toIntArray()
        val dp2 = IntArray(1 shl lists.size)
        for (mask in 1 until dp2.size) {
            fun check(x: Int): Boolean {
                var cnt = 0
                for (i in lists.indices) {
                    if ((mask and (1 shl i)) == 0) {
                        continue
                    }
                    cnt += upperBound(lists[i], sortedVals[x])
                }
                return cnt >= (dp1[mask] + 1) / 2
            }

            var left = 0
            var right = sortedVals.size - 1
            while (left <= right) {
                val mid = left + (right - left) / 2
                if (check(mid)) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            }
            dp2[mask] = sortedVals[left]
        }
        val dp3 = LongArray(1 shl lists.size)
        for (mask in 1 until dp3.size) {
            if ((mask and (mask - 1)) == 0) {
                continue
            }
            dp3[mask] = Long.MAX_VALUE
            var submask = (mask - 1) and mask
            while (submask > (mask xor submask)) {
                dp3[mask] = minOf(dp3[mask], dp3[submask] + dp3[mask xor submask] + abs(dp2[submask] - dp2[mask xor submask]) + dp1[mask])
                submask = (submask - 1) and mask
            }
        }
        return dp3.last()
    }
}
