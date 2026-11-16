package minimumadditionstomakevalidstring

// Time:  O(n)
// Space: O(1)

class Solution {
    fun addMinimum(word: String): Int {
        var cnt = 0
        for (i in word.indices) {
            if (i - 1 < 0 || word[i - 1] >= word[i]) {
                ++cnt
            }
        }
        return 3 * cnt - word.length
    }
}
