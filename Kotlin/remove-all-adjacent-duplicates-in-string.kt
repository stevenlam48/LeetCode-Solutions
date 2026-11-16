package removealladjacentduplicatesinstring
// Time:  O(n)
// Space: O(n)

class Solution {
    fun removeDuplicates(S: String): String {
        val result = StringBuilder()
        for (c in S) {
            if (result.isNotEmpty() && result.last() == c) {
                result.setLength(result.length - 1)
            } else {
                result.append(c)
            }
        }
        return result.toString()
    }
}
