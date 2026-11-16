package rearrangearraybyremovingdistinctvalues
// Time:  O(nlogn)
// Space: O(n)
class Solution {
    fun rearrangeArray(nums: IntArray): IntArray {
        val count = HashMap<Int, Int>()
        for (x in nums) {
            count[x] = (count[x] ?: 0) + 1
        }
        var values = count.keys.sorted()
        val result = mutableListOf<Int>()
        while (values.isNotEmpty()) {
            val newValues = mutableListOf<Int>()
            for (x in values) {
                result.add(x)
                val remaining = count[x]!! - 1
                count[x] = remaining
                if (remaining != 0) {
                    newValues.add(x)
                }
            }
            values = newValues
        }
        return result.toIntArray()
    }
}
