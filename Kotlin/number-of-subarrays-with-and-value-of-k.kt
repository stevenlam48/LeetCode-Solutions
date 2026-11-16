package numberofsubarrayswithandvalueofk
// Time:  O(nlogr)
// Space: O(logr)

class Solution {
    fun countSubarrays(nums: IntArray, k: Int): Long {
        var result = 0L
        var dp = HashMap<Int, Int>()
        for (value in nums) {
            val newDp = HashMap<Int, Int>()
            if (value and k == k) {
                newDp[value] = newDp.getOrDefault(value, 0) + 1
                for ((andValue, count) in dp) {
                    val next = andValue and value
                    newDp[next] = newDp.getOrDefault(next, 0) + count
                }
                result += newDp.getOrDefault(k, 0)
            }
            dp = newDp
        }
        return result
    }
}
