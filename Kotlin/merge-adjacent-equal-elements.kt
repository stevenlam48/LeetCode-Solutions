package mergeadjacentequalelements
// Time:  O(n)
// Space: O(1)

class Solution {
    fun mergeAdjacent(nums: IntArray): LongArray {
        val result = mutableListOf<Long>()
        for (num in nums) {
            var x = num.toLong()
            while (result.isNotEmpty() && result.last() == x) {
                result.removeAt(result.size - 1)
                x *= 2
            }
            result.add(x)
        }
        return result.toLongArray()
    }
}
