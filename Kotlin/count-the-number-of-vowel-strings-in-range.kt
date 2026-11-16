package countthenumberofvowelstringsinrange
// Time:  O(n)
// Space: O(1)

class Solution {
    fun vowelStrings(words: List<String>, left: Int, right: Int): Int {
        val vowels = setOf('a', 'e', 'i', 'o', 'u')
        var result = 0
        for (i in left..right) {
            if (words[i].first() in vowels && words[i].last() in vowels) {
                ++result
            }
        }
        return result
    }
}
