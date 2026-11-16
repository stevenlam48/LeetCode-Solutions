package guesstheword

// Time:  O(n)
// Space: O(n)

interface Master {
    fun guess(word: String): Int
}

class Solution {
    fun findSecretWord(wordlist: List<String>, master: Master) {
        var possible = wordlist.indices.toMutableList()
        var n = 0
        while (n < 6) {
            val guess = findGuessWithMostFrequentChars(wordlist, possible)
            n = master.guess(wordlist[guess])
            val newPossible = ArrayList<Int>()
            for (j in possible) {
                if (match(wordlist[guess], wordlist[j]) == n) {
                    newPossible.add(j)
                }
            }
            possible = newPossible
        }
    }

    private fun findGuessWithMostFrequentChars(wordlist: List<String>, possible: List<Int>): Int {
        val count = Array(6) { IntArray(26) }
        for (i in 0 until 6) {
            for (p in possible) {
                ++count[i][wordlist[p][i] - 'a']
            }
        }
        var guess = 0
        var maxScore = 0
        for (p in possible) {
            var score = 0
            for (i in 0 until 6) {
                score += count[i][wordlist[p][i] - 'a']
            }
            if (score > maxScore) {
                maxScore = score
                guess = p
            }
        }
        return guess
    }

    private fun match(a: String, b: String): Int {
        var matches = 0
        for (i in a.indices) {
            if (a[i] == b[i]) {
                ++matches
            }
        }
        return matches
    }
}
