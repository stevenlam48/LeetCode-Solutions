package minimummovestomakearraycomplementary

// Time:  O(n + k)
// Space: O(k)

class Solution {
    fun minMoves(nums: IntArray, limit: Int): Int {
        val diff = IntArray(2 * (limit + 1))
        for (i in 0 until nums.size / 2) {
            val left = nums[i]
            val right = nums[nums.size - 1 - i]
            --diff[minOf(left, right) + 1]
            --diff[left + right]
            ++diff[left + right + 1]
            ++diff[maxOf(left, right) + limit + 1]
        }
        var result = nums.size
        var count = nums.size
        for (total in 2..limit * 2) {
            count += diff[total]
            result = minOf(result, count)
        }
        return result
    }
}
