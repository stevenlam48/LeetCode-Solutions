package missingranges
// Time:  O(n)
// Space: O(1)

class Solution {
    fun findMissingRanges(nums: IntArray, lower: Int, upper: Int): List<String> {
        val ranges = mutableListOf<String>()
        var pre = lower.toLong() - 1
        var cur = 0L
        for (i in 0..nums.size) {
            cur = if (i == nums.size) upper.toLong() + 1 else nums[i].toLong()
            if (cur - pre >= 2) {
                ranges.add(getRange((pre + 1).toInt(), (cur - 1).toInt()))
            }
            pre = cur
        }
        return ranges
    }

    private fun getRange(lower: Int, upper: Int): String {
        return if (lower == upper) lower.toString() else "$lower->$upper"
    }
}
