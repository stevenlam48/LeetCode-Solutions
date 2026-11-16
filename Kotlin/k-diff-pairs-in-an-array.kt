package kdiffpairsinanarray
// Time:  O(n)
// Space: O(n)

class Solution {
    fun findPairs(nums: IntArray, k: Int): Int {
        if (k < 0) {
            return 0
        }
        val result = HashSet<Int>()
        val lookup = HashSet<Int>()
        for (num in nums) {
            if (lookup.contains(num - k)) {
                result.add(num - k)
            }
            if (lookup.contains(num + k)) {
                result.add(num)
            }
            lookup.add(num)
        }
        return result.size
    }
}
