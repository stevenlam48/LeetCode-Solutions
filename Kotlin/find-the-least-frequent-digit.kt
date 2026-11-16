package findtheleastfrequentdigit
// Time:  O(logn + 10)
// Space: O(10)

class Solution {
    fun getLeastFrequentDigit(n: Int): Int {
        var value = n
        val cnt = IntArray(10)
        while (value != 0) {
            ++cnt[value % 10]
            value /= 10
        }
        var mn = Int.MAX_VALUE
        for (x in cnt) {
            if (x != 0) {
                mn = minOf(mn, x)
            }
        }
        var i = 0
        while (i < cnt.size && cnt[i] != mn) {
            ++i
        }
        return i
    }
}
