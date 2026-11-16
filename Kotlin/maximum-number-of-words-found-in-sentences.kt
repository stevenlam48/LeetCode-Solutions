package maximumnumberofwordsfoundinsentences

// Time:  O(n)
// Space: O(1)

class Solution {
    fun mostWordsFound(sentences: Array<String>): Int {
        return 1 + sentences.maxOf { s -> s.count { it == ' ' } }
    }
}
