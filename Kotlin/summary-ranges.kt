package summaryranges

// Time:  O(n)
// Space: O(1)

class Solution {
    fun summaryRanges(nums: IntArray): List<String> {
        val ranges = ArrayList<String>()
        if (nums.isEmpty()) {
            return ranges
        }

        var start = nums[0]
        var end = nums[0]
        for (i in 1..nums.size) {
            if (i < nums.size && nums[i].toLong() == end.toLong() + 1) {
                end = nums[i]
            } else {
                var range = start.toString()
                if (start != end) {
                    range += "->" + end
                }
                ranges.add(range)
                if (i < nums.size) {
                    start = nums[i]
                    end = nums[i]
                }
            }
        }

        return ranges
    }
}
