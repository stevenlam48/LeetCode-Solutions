package checkiftwostringarraysareequivalent

// Time:  O(n), n is the total length of word1 and word2
// Space: O(1)

class Solution {
    fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {
        var idx1 = 0
        var idx2 = 0
        var arrIdx1 = 0
        var arrIdx2 = 0
        while (arrIdx1 < word1.size && arrIdx2 < word2.size) {
            if (word1[arrIdx1][idx1] != word2[arrIdx2][idx2]) {
                break
            }
            ++idx1
            if (idx1 == word1[arrIdx1].length) {
                idx1 = 0
                ++arrIdx1
            }
            ++idx2
            if (idx2 == word2[arrIdx2].length) {
                idx2 = 0
                ++arrIdx2
            }
        }
        return arrIdx1 == word1.size && arrIdx2 == word2.size
    }
}
