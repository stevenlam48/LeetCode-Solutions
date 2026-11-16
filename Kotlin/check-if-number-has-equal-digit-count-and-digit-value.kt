package checkifnumberhasequaldigitcountanddigitvalue

// Time:  O(n)
// Space: O(1)
class Solution {
    fun digitCount(num: String): Boolean {
        val cnt = IntArray(10)
        for (x in num) {
            ++cnt[x - '0']
        }
        for (i in num.indices) {
            if (cnt[i] != num[i] - '0') {
                return false
            }
        }
        return true
    }
}
