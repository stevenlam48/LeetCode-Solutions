package numberofbeautifulpairs

// Time:  O(nlogr)
// Space: O(1)

class Solution {
    fun countBeautifulPairs(nums: IntArray): Int {
        var result = 0
        val cnt = IntArray(10)
        for (x0 in nums) {
            var x = x0
            for (i in 1..9) {
                if (gcd(i, x % 10) == 1) {
                    result += cnt[i]
                }
            }
            while (x >= 10) {
                x /= 10
            }
            ++cnt[x]
        }
        return result
    }

    private fun gcd(a: Int, b: Int): Int {
        var a = a
        var b = b
        while (b != 0) {
            val tmp = b
            b = a % b
            a = tmp
        }
        return a
    }
}
