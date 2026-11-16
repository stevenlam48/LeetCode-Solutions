package minimumoperationstomakesubarrayelementsequal

import java.util.TreeSet

// Time:  O(nlogk)
// Space: O(k)

// math, two pointers, sliding window, bst
class Solution {
    fun minOperations(nums: IntArray, k: Int): Long {
        val left = TreeSet<IntArray>(COMPARATOR)
        val right = TreeSet<IntArray>(COMPARATOR)
        var totalLeft = 0L
        var totalRight = 0L

        fun rebalance() {
            if (left.size + 1 < right.size) {
                val e = right.first()
                right.remove(e)
                totalRight -= e[0].toLong()
                left.add(intArrayOf(-e[0], -e[1]))
                totalLeft += e[0].toLong()
            } else if (left.size > right.size) {
                val e = left.first()
                left.remove(e)
                totalLeft -= (-e[0]).toLong()
                right.add(intArrayOf(-e[0], -e[1]))
                totalRight += (-e[0]).toLong()
            }
        }

        var result = Long.MAX_VALUE
        for (i in nums.indices) {
            if (left.isNotEmpty() && -left.first()[0] > nums[i]) {
                left.add(intArrayOf(-nums[i], -i))
                totalLeft += nums[i]
            } else {
                right.add(intArrayOf(nums[i], i))
                totalRight += nums[i]
            }
            rebalance()
            val j = i - (k - 1)
            if (j >= 0) {
                result = minOf(result, (totalRight - (if (k % 2 == 1) right.first()[0].toLong() else 0L)) - totalLeft)
                val key = intArrayOf(-nums[j], -j)
                if (left.contains(key)) {
                    left.remove(key)
                    totalLeft -= nums[j]
                } else {
                    right.remove(intArrayOf(nums[j], j))
                    totalRight -= nums[j]
                }
                rebalance()
            }
        }
        return result
    }

    private companion object {
        val COMPARATOR = Comparator<IntArray> { a, b ->
            if (a[0] != b[0]) a[0].compareTo(b[0]) else a[1].compareTo(b[1])
        }
    }
}
