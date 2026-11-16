package maxnumberofksumpairs

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maxOperations(nums: IntArray, k: Int): Int {
        val lookup = HashMap<Int, Int>()
        var result = 0
        for (num in nums) {
            if ((lookup[k - num] ?: 0) > 0) {
                lookup[k - num] = lookup[k - num]!! - 1
                result++
            } else {
                lookup[num] = (lookup[num] ?: 0) + 1
            }
        }
        return result
    }
}
