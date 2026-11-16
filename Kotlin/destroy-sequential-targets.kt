package destroysequentialtargets

// Time:  O(n)
// Space: O(s), s is the value of space

class Solution {
    fun destroyTargets(nums: IntArray, space: Int): Int {
        val cnt = HashMap<Int, Int>()
        var mx = 0
        for (x in nums) {
            val c = cnt.getOrDefault(x % space, 0) + 1
            cnt[x % space] = c
            mx = maxOf(mx, c)
        }
        var result = Int.MAX_VALUE
        for (x in nums) {
            if (cnt[x % space] == mx) {
                result = minOf(result, x)
            }
        }
        return result
    }
}
