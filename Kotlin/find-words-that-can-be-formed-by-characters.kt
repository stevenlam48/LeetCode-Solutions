package findwordsthatcanbeformedbycharacters
// Time:  O(m * n), m is the length of chars, n is the number of words
// Space: O(1)

class Solution {
    fun countCharacters(words: List<String>, chars: String): Int {
        val count = counter(chars)
        var result = 0
        for (word in words) {
            if (check(word, chars, count)) {
                result += word.length
            }
        }
        return result
    }

    private fun counter(s: String): HashMap<Char, Int> {
        val result = HashMap<Char, Int>()
        for (c in s) {
            result[c] = result.getOrDefault(c, 0) + 1
        }
        return result
    }

    private fun check(word: String, chars: String, count: HashMap<Char, Int>): Boolean {
        if (word.length > chars.length) {
            return false
        }
        val currCount = HashMap<Char, Int>()
        for (c in word) {
            currCount[c] = currCount.getOrDefault(c, 0) + 1
            if (!count.containsKey(c) || count.getValue(c) < currCount.getValue(c)) {
                return false
            }
        }
        return true
    }
}
