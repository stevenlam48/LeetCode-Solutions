package removealladjacentduplicatesinstringii
// Time:  O(n)
// Space: O(n)

class Solution {
    fun removeDuplicates(s: String, k: Int): String {
        val chars = mutableListOf('^')
        val counts = mutableListOf(0)
        for (c in s) {
            if (chars.last() == c) {
                if (++counts[counts.lastIndex] == k) {
                    chars.removeAt(chars.lastIndex)
                    counts.removeAt(counts.lastIndex)
                }
            } else {
                chars.add(c)
                counts.add(1)
            }
        }
        val result = StringBuilder()
        for (i in chars.indices) {
            repeat(counts[i]) {
                result.append(chars[i])
            }
        }
        return result.toString()
    }
}
