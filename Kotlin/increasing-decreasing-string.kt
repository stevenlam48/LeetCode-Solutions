package increasingdecreasingstring

// Time:  O(n)
// Space: O(1)

class Solution {
    fun sortString(s: String): String {
        val result = StringBuilder()
        val count = counter(s)
        while (result.length != s.length) {
            for (c in count.indices) {
                if (count[c] > 0) {
                    result.append('a' + c)
                    --count[c]
                }
            }
            for (c in count.indices.reversed()) {
                if (count[c] > 0) {
                    result.append('a' + c)
                    --count[c]
                }
            }
        }
        return result.toString()
    }

    private fun counter(word: String): IntArray {
        val count = IntArray(26)
        for (c in word) {
            ++count[c - 'a']
        }
        return count
    }
}
