package findallnumbersdisappearedinanarrayiii

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun findDisappearedNumbers(nums: IntArray, lower: Int, upper: Int): Array<IntArray> {
        val result = ArrayList<IntArray>()
        nums.sort()
        var start = lower
        for (x in nums) {
            if (x < start) {
                continue
            }
            if (x > upper) {
                break
            }
            if (start <= x - 1) {
                result.add(intArrayOf(start, x - 1))
            }
            start = x + 1
        }
        if (start <= upper) {
            result.add(intArrayOf(start, upper))
        }
        return result.toTypedArray()
    }
}
