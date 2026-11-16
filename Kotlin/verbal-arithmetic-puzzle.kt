package verbalarithmeticpuzzle

// Time:  O(10!* n * l)
// Space: O(n * l)

class Solution {
    fun isSolvable(words: List<String>, result: String): Boolean {
        val reversedWords = words.map { it.reversed() }
        val reversedResult = result.reversed()
        val lookup = HashMap<Char, Int>()
        val used = HashSet<Int>()
        return backtracking(reversedWords, reversedResult, 0, 0, 0, lookup, used)
    }

    private fun backtracking(
        words: List<String>,
        result: String,
        i: Int,
        j: Int,
        carry: Int,
        lookup: HashMap<Char, Int>,
        used: HashSet<Int>
    ): Boolean {
        if (j == result.length) {
            return carry == 0
        }
        if (i != words.size) {
            if (j >= words[i].length || lookup.containsKey(words[i][j])) {
                return backtracking(words, result, i + 1, j, carry, lookup, used)
            }
            for (value in 0..9) {
                if (value in used || (value == 0 && j == words[i].length - 1)) {
                    continue
                }
                lookup[words[i][j]] = value
                used.add(value)
                if (backtracking(words, result, i + 1, j, carry, lookup, used)) {
                    return true
                }
                used.remove(value)
                lookup.remove(words[i][j])
            }
            return false
        }
        var total = carry
        for (word in words) {
            if (j < word.length) {
                total += lookup[word[j]]!!
            }
        }
        val nextCarry = total / 10
        val value = total % 10
        if (lookup.containsKey(result[j])) {
            return value == lookup[result[j]] &&
                backtracking(words, result, 0, j + 1, nextCarry, lookup, used)
        }
        if (value in used || (value == 0 && j == result.length - 1)) {
            return false
        }
        lookup[result[j]] = value
        used.add(value)
        if (backtracking(words, result, 0, j + 1, nextCarry, lookup, used)) {
            return true
        }
        used.remove(value)
        lookup.remove(result[j])
        return false
    }
}
