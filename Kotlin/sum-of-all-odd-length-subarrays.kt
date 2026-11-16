package sumofalloddlengthsubarrays

// Time:  O(n)
// Space: O(1)
class Solution {
    fun sumOddLengthSubarrays(arr: IntArray): Int {
        var result = 0
        for (i in arr.indices) {
            result += arr[i] * ceilDivide((i + 1) * (arr.size - i), 2)
        }
        return result
    }

    private fun ceilDivide(a: Int, b: Int): Int {
        return (a + (b - 1)) / b
    }
}
