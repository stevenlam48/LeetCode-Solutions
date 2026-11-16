package arraypartitioni

// Time:  O(r), r is the range size of the integers
// Space: O(r)

class Solution {
    fun arrayPairSum(nums: IntArray): Int {
        val LEFT = -10000
        val RIGHT = 10000
        val lookup = IntArray(RIGHT - LEFT + 1)
        for (num in nums) {
            ++lookup[num - LEFT]
        }
        var r = 0
        var result = 0
        for (i in LEFT..RIGHT) {
            result += (lookup[i - LEFT] + 1 - r) / 2 * i
            r = (lookup[i - LEFT] + r) % 2
        }
        return result
    }
}
