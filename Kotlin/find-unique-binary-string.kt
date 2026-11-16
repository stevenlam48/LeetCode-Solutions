package finduniquebinarystring
// Time:  O(n)
// Space: O(1)

class Solution {
    fun findDifferentBinaryString(nums: List<String>): String {
        val result = StringBuilder()
        for (i in nums.indices) {
            result.append(if (nums[i][i] == '0') '1' else '0')
        }
        return result.toString()
    }
}
