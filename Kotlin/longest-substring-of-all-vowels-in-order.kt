package longestsubstringofallvowelsinorder
// Time:  O(n)
// Space: O(1)

class Solution {
    fun longestBeautifulSubstring(word: String): Int {
        var result = 0
        var length = 1
        var count = 1
        for (i in 0 until word.length - 1) {
            if (word[i] > word[i + 1]) {
                length = 1
                count = 1
            } else {
                ++length
                if (word[i] < word[i + 1]) {
                    ++count
                }
            }
            if (count == 5) {
                result = maxOf(result, length)
            }
        }
        return result
    }
}
