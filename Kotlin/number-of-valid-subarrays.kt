package numberofvalidsubarrays

// Time:  O(n)
// Space: O(n)

class Solution {
    fun validSubarrays(nums: IntArray): Int {
        var result = 0
        val s = ArrayDeque<Int>()
        for (num in nums) {
            while (s.isNotEmpty() && s.last() > num) {
                s.removeLast()
            }
            s.addLast(num)
            result += s.size
        }
        return result
    }
}
