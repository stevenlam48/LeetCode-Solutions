package findavalueofamysteriousfunctionclosesttotarget

import kotlin.math.abs

// Time:  O(nlogm), m is the max value of arr
// Space: O(logm)

class Solution {
    fun closestToTarget(arr: IntArray, target: Int): Int {
        val LOGM = 20
        val count = BitCount(LOGM)
        var result = Int.MAX_VALUE
        var left = 0
        for (right in arr.indices) {
            count.add(arr[right])
            while (left <= right) {
                val f = count.bitAnd()
                result = minOf(result, abs(f - target))
                if (f >= target) {
                    break
                }
                count.remove(arr[left++])
            }
        }
        return result
    }

    private class BitCount(size: Int) {
        private var l = 0
        private val n = size
        private val count = IntArray(size)

        fun bitAnd(): Int {
            var num = 0
            for (i in 0 until n) {
                if (count[i] == l) {
                    num = num or (1 shl i)
                }
            }
            return num
        }

        fun add(num: Int) {
            ++l
            for (i in 0 until n) {
                if (num and (1 shl i) != 0) {
                    ++count[i]
                }
            }
        }

        fun remove(num: Int) {
            --l
            for (i in 0 until n) {
                if (num and (1 shl i) != 0) {
                    --count[i]
                }
            }
        }
    }
}
