package relocatemarbles
// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun relocateMarbles(nums: IntArray, moveFrom: IntArray, moveTo: IntArray): IntArray {
        val lookup = HashSet<Int>()
        for (num in nums) {
            lookup.add(num)
        }
        for (i in moveFrom.indices) {
            lookup.remove(moveFrom[i])
            lookup.add(moveTo[i])
        }
        val result = lookup.toIntArray()
        result.sort()
        return result
    }
}
