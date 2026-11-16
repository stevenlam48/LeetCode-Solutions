package sumofuniqueelements

// Time:  O(n)
// Space: O(n)

class Solution {
    fun sumOfUnique(nums: IntArray): Int {
        val count = HashMap<Int, Int>()
        for (num in nums) {
            count[num] = (count[num] ?: 0) + 1
        }
        var total = 0
        for ((key, value) in count) {
            total += if (value == 1) key else 0
        }
        return total
    }
}
