package minimumdistancebetweenthreeequalelementsii
// Time:  O(n)
// Space: O(n)

class Solution {
    fun minimumDistance(nums: IntArray): Int {
        var result = Int.MAX_VALUE
        val lookup = HashMap<Int, MutableList<Int>>()
        for (i in nums.indices) {
            val positions = lookup.getOrPut(nums[i]) { mutableListOf() }
            positions.add(i)
            if (positions.size < 3) {
                continue
            }
            result = minOf(result, 2 * (i - positions[positions.size - 3]))
        }
        return if (result != Int.MAX_VALUE) result else -1
    }
}
