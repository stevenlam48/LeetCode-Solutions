package maximumdistancebetweenunequalwordsinarrayi
// Time:  O(n * l)
// Space: O(1)

class Solution {
    fun maxDistance(words: List<String>): Int {
        for (i in 0..words.size / 2) {
            if (words[words.size - 1 - i] != words[0] || words[i] != words.last()) {
                return words.size - i
            }
        }
        return 0
    }
}
