package sentencesimilarity

// Time:  O(n + p)
// Space: O(p)

class Solution {
    fun areSentencesSimilar(words1: List<String>, words2: List<String>, pairs: List<List<String>>): Boolean {
        if (words1.size != words2.size) {
            return false
        }
        val lookup = HashSet<Pair<String, String>>()
        for (pair in pairs) {
            lookup.add(Pair(pair[0], pair[1]))
            lookup.add(Pair(pair[1], pair[0]))
        }
        for (i in words1.indices) {
            if (words1[i] != words2[i] && Pair(words1[i], words2[i]) !in lookup) {
                return false
            }
        }
        return true
    }
}
