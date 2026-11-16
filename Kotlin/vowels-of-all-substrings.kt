package vowelsofallsubstrings
// Time:  O(n)
// Space: O(1)

class Solution {
    fun countVowels(word: String): Long {
        val vowels = hashSetOf('a', 'e', 'i', 'o', 'u')
        var result = 0L
        for (i in word.indices) {
            if (word[i] in vowels) {
                result += (i + 1).toLong() * (word.length - i)
            }
        }
        return result
    }
}
