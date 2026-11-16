package bitwiseorofevennumbersinanarray

// Time:  O(n)
// Space: O(1)

// array
class Solution {
    fun evenNumberBitwiseORs(nums: IntArray): Int {
        var result = 0
        for (x in nums) {
            result = result or if (x % 2 == 0) x else 0
        }
        return result
    }
}
