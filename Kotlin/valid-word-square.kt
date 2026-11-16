package validwordsquare
// Time:  O(m * n)
// Space: O(1)

class Solution {
    fun validWordSquare(words: List<String>): Boolean {
        for (i in words.indices) {
            for (j in words[i].indices) {
                if (j >= words.size || i >= words[j].length ||
                    words[j][i] != words[i][j]
                ) {
                    return false
                }
            }
        }
        return true
    }
}
