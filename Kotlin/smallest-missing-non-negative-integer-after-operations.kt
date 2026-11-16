package smallestmissingnonnegativeintegerafteroperations
// Time:  O(n)
// Space: O(k), k = value

class Solution {
    fun findSmallestInteger(nums: IntArray, value: Int): Int {
        val cnt = HashMap<Int, Int>()
        for (x in nums) {
            val remainder = (x % value + value) % value
            cnt[remainder] = (cnt[remainder] ?: 0) + 1
        }
        var mn = 0
        for (i in 0 until value) {
            if ((cnt[i] ?: 0) < (cnt[mn] ?: 0)) {
                mn = i
            }
        }
        return value * (cnt[mn] ?: 0) + mn
    }
}
