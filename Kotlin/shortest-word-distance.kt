package shortestworddistance

// Time:  O(n)
// Space: O(1)
class Solution {
    fun shortestDistance(words: List<String>, word1: String, word2: String): Int {
        var dist = Int.MAX_VALUE
        var index1 = -1
        var index2 = -1
        for (i in words.indices) {
            if (words[i] == word1) {
                index1 = i
            } else if (words[i] == word2) {
                index2 = i
            }
            if (index1 != -1 && index2 != -1) {
                dist = minOf(dist, kotlin.math.abs(index1 - index2))
            }
        }
        return dist
    }
}
