package countindiceswithoppositeparity

// Time:  O(n)
// Space: O(1)

class Solution {
    fun countOppositeParity(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        val cnt = IntArray(2)
        for (i in nums.size - 1 downTo 0) {
            result[i] = cnt[1 xor (nums[i] % 2)]
            ++cnt[nums[i] % 2]
        }
        return result
    }
}
