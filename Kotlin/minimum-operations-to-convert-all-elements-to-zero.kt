package minimumoperationstoconvertallelementstozero

// Time:  O(n)
// Space: O(n)

// greedy, mono stack
class Solution {
    fun minOperations(nums: IntArray): Int {
        var result = 0
        val stk = ArrayDeque<Int>()
        stk.addLast(0)
        for (x in nums) {
            while (stk.isNotEmpty() && stk.last() > x) {
                stk.removeLast()
            }
            if (stk.last() < x) {
                ++result
                stk.addLast(x)
            }
        }
        return result
    }
}
