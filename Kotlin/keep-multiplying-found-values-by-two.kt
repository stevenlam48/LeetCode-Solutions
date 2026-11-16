package keepmultiplyingfoundvaluesbytwo

// Time:  O(n)
// Space: O(n)

class Solution {
    fun findFinalValue(nums: IntArray, original: Int): Int {
        val lookup = nums.toHashSet()
        var result = original
        while (result in lookup) {
            result *= 2
        }
        return result
    }
}
