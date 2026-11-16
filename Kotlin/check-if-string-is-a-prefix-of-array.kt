package checkifstringisaprefixofarray

// Time:  O(n)
// Space: O(1)
class Solution {
    fun isPrefixString(s: String, words: List<String>): Boolean {
        var i = 0
        var j = 0
        for (c in s) {
            if (i == words.size || words[i][j] != c) {
                return false
            }
            if (++j == words[i].length) {
                ++i
                j = 0
            }
        }
        return j == 0
    }
}
