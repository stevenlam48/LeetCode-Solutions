package countnumberswithuniquedigits

// Time:  O(n)
// Space: O(1)
class Solution {
    fun countNumbersWithUniqueDigits(n: Int): Int {
        if (n == 0) {
            return 1
        }
        var result = 1
        var cnt = 1
        for (i in 0 until n - 1) {
            cnt *= 9 - i
            result += cnt
        }
        return 1 + 9 * result
    }
}
