package maximizesumafteratmostkdigitrearrangements

// Time:  O(nlogr)
// Space: O(n)

class Solution {
    fun maximizeSum(nums: IntArray, k: Int): Long {
        val f = { n: Int ->
            val cnt = IntArray(10)
            var x = n
            while (x != 0) {
                ++cnt[x % 10]
                x /= 10
            }
            var d = 0
            for (i in cnt.indices.reversed()) {
                repeat(cnt[i]) {
                    d = d * 10 + i
                }
            }
            d - n
        }
        val candidates = IntArray(nums.size) { f(nums[it]) }
        candidates.sortDescending()
        var result = 0L
        for (x in nums) {
            result += x
        }
        for (i in 0 until k) {
            result += candidates[i]
        }
        return result
    }
}
