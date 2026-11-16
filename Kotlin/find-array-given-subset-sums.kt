package findarraygivensubsetsums

// Time:  O(n * 2^n), len(sums) = 2^n
// Space: O(1)

class Solution {
    fun recoverArray(n: Int, sums: IntArray): IntArray {
        sums.sort()
        var shift = 0
        var length = sums.size
        val result = ArrayList<Int>()
        var remaining = n
        while (remaining-- > 0) {
            val newShift = sums[0] - sums[1]
            var hasZero = false
            var j = 0
            var k = 0
            for (i in 0 until length) {
                if (k < j && sums[k] == sums[i]) {
                    ++k
                } else {
                    if (shift == sums[i] - newShift) {
                        hasZero = true
                    }
                    sums[j++] = sums[i] - newShift
                }
            }
            if (hasZero) {
                result.add(newShift)
            } else {
                result.add(-newShift)
                shift -= newShift
            }
            length /= 2
        }
        return result.toIntArray()
    }
}
