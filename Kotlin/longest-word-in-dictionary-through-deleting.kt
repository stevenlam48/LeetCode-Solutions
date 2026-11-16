package longestwordindictionarythroughdeleting

// Time:  O((d * l) * logd), l is the average length of words
// Space: O(1)

class Solution {
    fun findLongestWord(s: String, d: Array<String>): String {
        d.sortWith(Comparator { a: String, b: String ->
            if (a.length != b.length) b.length - a.length else a.compareTo(b)
        })

        for (word in d) {
            var i = 0
            for (c in s) {
                if (i < word.length && word[i] == c) {
                    ++i
                }
            }
            if (i == word.length) {
                return word
            }
        }
        return ""
    }
}
