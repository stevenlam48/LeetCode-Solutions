package sumofintegerswithmaximumdigitrange

// Time:  O(nlogr)
// Space: O(1)

// array
class Solution {
    fun maxDigitRange(nums: IntArray): Int {
        fun count(x0: Int): Int {
            var x = x0
            var mx = -1
            var mn = 10
            while (x != 0) {
                val r = x % 10
                mx = maxOf(mx, r)
                mn = minOf(mn, r)
                x /= 10
            }
            return mx - mn
        }

        var result = 0
        var mx = 0
        for (x in nums) {
            val v = count(x)
            if (v > mx) {
                mx = v
                result = x
            } else if (v == mx) {
                result += x
            }
        }
        return result
    }
}
