package maximumpalindromesafteroperations
// Time:  O(n * l + nlogn)
// Space: O(n)

class Solution {
    fun maxPalindromesAfterOperations(words: List<String>): Int {
        val count = IntArray(26)
        for (word in words) {
            for (c in word) {
                ++count[c - 'a']
            }
        }
        var curr = 0
        for (x in count) {
            curr += x / 2
        }
        val lengths = IntArray(words.size) { words[it].length }
        lengths.sort()
        for (i in lengths.indices) {
            curr -= lengths[i] / 2
            if (curr < 0) {
                return i
            }
        }
        return words.size
    }
}
