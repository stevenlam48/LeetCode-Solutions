package reorderedpowerof2
// Time:  O((logn)^2) = O(1) due to n is a 32-bit number
// Space: O(logn) = O(1)

class Solution {
    fun reorderedPowerOf2(N: Int): Boolean {
        val count = counter(N)
        for (i in 0 until 31) {
            if (count.contentEquals(counter(1 shl i))) {
                return true
            }
        }
        return false
    }

    private fun counter(N: Int): IntArray {
        var value = N
        val result = IntArray(10)
        while (value != 0) {
            ++result[value % 10]
            value /= 10
        }
        return result
    }
}
