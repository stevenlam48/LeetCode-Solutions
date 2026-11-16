package minimumlengthofstringafteroperations

// Time:  O(n + 26)
// Space: O(26)

class Solution {
    fun minimumLength(s: String): Int {
        val cnt = IntArray(26)
        for (x in s) {
            ++cnt[x - 'a']
        }
        var total = 0
        for (x in cnt) {
            total += if (x != 0) 2 - x % 2 else 0
        }
        return total
    }
}
