package makenumberofdistinctcharactersequal

// Time:  O(m + n + 26^2)
// Space: O(26)

// freq table
class Solution {
    fun isItPossible(word1: String, word2: String): Boolean {
        val cnt1 = IntArray(26)
        for (c in word1) {
            ++cnt1[c - 'a']
        }
        val cnt2 = IntArray(26)
        for (c in word2) {
            ++cnt2[c - 'a']
        }
        val c1 = cnt1.count { it != 0 }
        val c2 = cnt2.count { it != 0 }
        for (i in cnt1.indices) {
            if (cnt1[i] == 0) {
                continue
            }
            for (j in cnt2.indices) {
                if (cnt2[j] == 0) {
                    continue
                }
                if (i == j) {
                    if (c1 == c2) {
                        return true
                    }
                } else {
                    var newC1 = c1
                    var newC2 = c2
                    if (cnt1[i] == 1) {
                        --newC1
                    }
                    if (cnt1[j] == 0) {
                        ++newC1
                    }
                    if (cnt2[j] == 1) {
                        --newC2
                    }
                    if (cnt2[i] == 0) {
                        ++newC2
                    }
                    if (newC1 == newC2) {
                        return true
                    }
                }
            }
        }
        return false
    }
}
