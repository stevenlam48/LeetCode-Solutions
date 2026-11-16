package binarygap

// Time:  O(logn) = O(1) due to n is a 32-bit number
// Space: O(1)

class Solution {
    fun binaryGap(N: Int): Int {
        var result = 0
        var last = -1
        for (i in 0 until 32) {
            if (((N shr i) and 1) != 0) {
                if (last != -1) {
                    result = kotlin.math.max(result, i - last)
                }
                last = i
            }
        }
        return result
    }
}
