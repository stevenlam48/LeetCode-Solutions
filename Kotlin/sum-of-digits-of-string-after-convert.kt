package sumofdigitsofstringafterconvert

// Time:  O(n + logn + log(logn) + ...) = O(n)
// Space: O(1)
class Solution {
    fun getLucky(s: String, k: Int): Int {
        var total = 0
        for (c in s) {
            val num = c - 'a' + 1
            total += num / 10 + num % 10
        }
        var remaining = k - 1
        while (remaining > 0 && total > 9) {
            var newTotal = 0
            while (total != 0) {
                newTotal += total % 10
                total /= 10
            }
            total = newTotal
            --remaining
        }
        return total
    }
}
