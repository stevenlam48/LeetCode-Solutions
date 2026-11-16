package guessthenumberusingbitwisequestionsi

// Time:  O(logn):
// Space: O(1)

// bit manipulation
class Solution(private val commonSetBits: (Int) -> Int) {
    fun findNumber(): Int {
        var result = 0
        for (i in 0 until 30) {
            if (commonSetBits(1 shl i) != 0) {
                result = result or (1 shl i)
            }
        }
        return result
    }
}
