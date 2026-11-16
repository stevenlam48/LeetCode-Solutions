package sortarraybyincreasingfrequency

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun frequencySort(nums: IntArray): IntArray {
        val count = HashMap<Int, Int>()
        for (x in nums) {
            count[x] = (count[x] ?: 0) + 1
        }
        val result = nums.toMutableList()
        result.sortWith(Comparator { a, b ->
            if (count.getValue(a) == count.getValue(b)) {
                b.compareTo(a)
            } else {
                count.getValue(a).compareTo(count.getValue(b))
            }
        })
        return result.toIntArray()
    }
}
