package countnumberofdistinctintegersafterreverseoperations

// Time:  O(nlogr), r = max(nums)
// Space: O(n)

class Solution {
    fun countDistinctIntegers(nums: IntArray): Int {
        fun reverse(n: Int): Int {
            var n = n
            var result = 0
            while (n != 0) {
                result = result * 10 + n % 10
                n /= 10
            }
            return result
        }

        val lookup = nums.toHashSet()
        for (x in nums) {
            lookup.add(reverse(x))
        }
        return lookup.size
    }
}
