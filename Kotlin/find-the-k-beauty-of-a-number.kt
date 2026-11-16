package findthekbeautyofanumber

// Time:  O(logn)
// Space: O(logn)

class Solution {
    fun divisorSubstrings(num: Int, k: Int): Int {
        var result = 0
        val s = num.toString()
        var base = 1
        for (i in 1 until k) {
            base *= 10
        }
        var curr = 0
        for (i in s.indices) {
            if (i - k >= 0) {
                curr -= (s[i - k] - '0') * base
            }
            curr = curr * 10 + (s[i] - '0')
            if (i + 1 >= k) {
                if (curr != 0 && num % curr == 0) {
                    result += 1
                }
            }
        }
        return result
    }
}
