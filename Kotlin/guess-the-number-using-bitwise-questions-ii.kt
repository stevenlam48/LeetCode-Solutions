package guessthenumberusingbitwisequestionsii

// Time:  O(logr)
// Space: O(1)

// bit manipulation
class Solution(private val commonBits: (Int) -> Int) {
    fun findNumber(): Int {
        val bitCount = 30

        var result = 0
        var prev = commonBits(0)
        for (i in 0 until bitCount) {
            val curr = commonBits(1 shl i)
            if (curr - prev == 1) {
                result = result or (1 shl i)
            }
            prev = curr
        }
        return result
    }
}
