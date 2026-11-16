package findthenumberofsubarrayswhereboundaryelementsaremaximum

// Time:  O(n)
// Space: O(n)

class Solution {
    fun numberOfSubarrays(nums: IntArray): Long {
        var result = 0L
        val stk = mutableListOf<IntArray>()
        for (x in nums) {
            while (stk.isNotEmpty() && stk.last()[0] < x) {
                stk.removeAt(stk.lastIndex)
            }
            if (stk.isEmpty() || stk.last()[0] != x) {
                stk.add(intArrayOf(x, 0))
            }
            result += ++stk.last()[1]
        }
        return result
    }
}
