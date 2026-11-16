package maximumproductoftwodigits

// Time:  O(d + 10)
// Space: O(10)

// freq table, greedy
class Solution {
    fun maxProduct(n: Int): Int {
        val MAX_COUNT = 2
        val cnt = IntArray(10)
        var value = n
        while (value != 0) {
            ++cnt[value % 10]
            value /= 10
        }
        var result = 1
        var c = MAX_COUNT
        var d = 9
        while (d >= 0) {
            if (c == 0) {
                break
            }
            while (cnt[d] > 0) {
                if (c == 0) {
                    break
                }
                --c
                result *= d
                --cnt[d]
            }
            --d
        }
        return result
    }
}
