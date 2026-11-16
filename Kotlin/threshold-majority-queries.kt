package thresholdmajorityqueries
// Time:  O(nlogn + qlogq + (n + q) * sqrt(n) + q * n)
// Space: O(n + q)

import kotlin.math.max
import kotlin.math.sqrt

class Solution {
    fun subarrayMajority(nums: IntArray, queries: Array<IntArray>): IntArray {
        val sortedNums = nums.distinct().sorted()
        val numToIdx = HashMap<Int, Int>()
        for (i in sortedNums.indices) {
            numToIdx[sortedNums[i]] = i
        }

        val cnt = IntArray(numToIdx.size)
        val cnt2 = IntArray(nums.size + 1)
        var maxFreq = 0

        fun add(i: Int) {
            val idx = numToIdx[nums[i]]!!
            if (cnt[idx] != 0) {
                --cnt2[cnt[idx]]
            }
            ++cnt[idx]
            ++cnt2[cnt[idx]]
            maxFreq = max(maxFreq, cnt[idx])
        }

        fun remove(i: Int) {
            val idx = numToIdx[nums[i]]!!
            --cnt2[cnt[idx]]
            if (cnt2[maxFreq] == 0) {
                --maxFreq
            }
            --cnt[idx]
            if (cnt[idx] != 0) {
                ++cnt2[cnt[idx]]
            }
        }

        fun getAns(t: Int): Int {
            if (maxFreq < t) {
                return -1
            }
            var i = 0
            while (i < cnt.size && cnt[i] != maxFreq) {
                ++i
            }
            return sortedNums[i]
        }

        val result = IntArray(queries.size) { -1 }
        val blockSize = sqrt(nums.size.toDouble()).toInt() + 1
        val idxs = queries.indices.sortedWith(Comparator { a, b ->
            val i = queries[a][0] / blockSize
            val j = queries[b][0] / blockSize
            if (i != j) {
                i.compareTo(j)
            } else if (i and 1 != 0) {
                queries[a][1].compareTo(queries[b][1])
            } else {
                queries[b][1].compareTo(queries[a][1])
            }
        })
        var left = 0
        var right = -1
        for (i in idxs) {
            val l = queries[i][0]
            val r = queries[i][1]
            val t = queries[i][2]
            while (left > l) {
                --left
                add(left)
            }
            while (right < r) {
                ++right
                add(right)
            }
            while (left < l) {
                remove(left)
                ++left
            }
            while (right > r) {
                remove(right)
                --right
            }
            result[i] = getAns(t)
        }
        return result
    }
}
