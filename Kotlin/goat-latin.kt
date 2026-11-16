package goatlatin

// Time:  O(n + w^2), n = w * l,
//                    n is the length of S,
//                    w is the number of words,
//                    l is the average of word lengths
// Space: O(l)

class Solution {
    fun toGoatLatin(s: String): String {
        val vowels = hashSetOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        val result = StringBuilder()
        val word = StringBuilder()
        var count = 0
        for (i in s.indices) {
            if (s[i] != ' ') {
                word.append(s[i])
                if (i != s.length - 1) {
                    continue
                }
            }
            if (word[0] !in vowels) {
                word.append(word[0])
                word.deleteCharAt(0)
            }
            word.append("ma")
            word.append("a".repeat(++count))
            result.append(word)
            result.append(' ')
            word.clear()
        }
        result.deleteCharAt(result.lastIndex)
        return result.toString()
    }
}
