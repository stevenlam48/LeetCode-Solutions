package maximalrangethateachelementismaximuminit

// Time:  O(n)
// Space: O(n)

// mono stack
class Solution {
    fun maximumLengthOfRanges(nums: IntArray): IntArray {
        val n = nums.size
        val result = IntArray(n)
        val a = IntArray(n + 1)
        for (i in 0 until n) a[i] = nums[i]
        a[n] = Int.MAX_VALUE
        val stk = ArrayDeque<Int>()
        stk.addLast(-1)
        for (i in 0..n) {
            while (stk.last() != -1 && a[stk.last()] < a[i]) {
                val j = stk.removeLast()
                result[j] = (i - 1) - stk.last()
            }
            stk.addLast(i)
        }
        return result
    }
}
