package longestunequaladjacentgroupssubsequencei

// Time:  O(n)
// Space: O(1)

// greedy
class Solution {
    fun getWordsInLongestSubsequence(n: Int, words: Array<String>, groups: IntArray): List<String> {
        val result = mutableListOf(words[0])
        for (i in 1 until n) {
            if (groups[i] != groups[i - 1]) {
                result.add(words[i])
            }
        }
        return result
    }
}
