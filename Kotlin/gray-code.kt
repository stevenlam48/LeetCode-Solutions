package graycode

// Time:  (2^n)
// Space: O(1)

class Solution {
    fun grayCode(n: Int): IntArray {
        val result = mutableListOf(0)
        for (i in 0 until n) {
            for (j in result.size - 1 downTo 0) {
                result.add((1 shl i) or result[j])
            }
        }
        return result.toIntArray()
    }
}
