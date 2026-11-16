package findmaximumnumberofstringpairs

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maximumNumberOfStringPairs(words: List<String>): Int {
        var result = 0
        val cnt = IntArray(26 * 26)
        for (w in words) {
            result += cnt[(w[1] - 'a') * 26 + (w[0] - 'a')]
            ++cnt[(w[0] - 'a') * 26 + (w[1] - 'a')]
        }
        return result
    }
}
