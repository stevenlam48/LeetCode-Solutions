package maximumscorewordsformedbyletters

// Time:  O(n * 2^n)
// Space: O(n)

class Solution {
    fun maxScoreWords(words: Array<String>, letters: CharArray, score: IntArray): Int {
        val letterCount = HashMap<Char, Int>()
        for (c in letters) {
            letterCount[c] = (letterCount[c] ?: 0) + 1
        }
        val wordCounts = Array(words.size) { HashMap<Char, Int>() }
        val wordScores = IntArray(words.size)
        for (i in words.indices) {
            for (c in words[i]) {
                wordCounts[i][c] = (wordCounts[i][c] ?: 0) + 1
                wordScores[i] += score[c - 'a']
            }
        }
        var result = 0
        fun backtracking(curr: Int, currScore: Int) {
            result = maxOf(result, currScore)
            for (i in curr until words.size) {
                if (wordCounts[i].any { (k, v) -> (letterCount[k] ?: 0) < v }) {
                    continue
                }
                for ((k, v) in wordCounts[i]) {
                    letterCount[k] = (letterCount[k] ?: 0) - v
                }
                backtracking(i + 1, currScore + wordScores[i])
                for ((k, v) in wordCounts[i]) {
                    letterCount[k] = (letterCount[k] ?: 0) + v
                }
            }
        }
        backtracking(0, 0)
        return result
    }
}
