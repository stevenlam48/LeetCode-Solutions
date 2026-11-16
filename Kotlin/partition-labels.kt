package partitionlabels

// Time:  O(n)
// Space: O(n)

class Solution {
    fun partitionLabels(s: String): IntArray {
        val lookup = HashMap<Char, Int>()
        for (i in s.indices) {
            lookup[s[i]] = i
        }
        var first = 0
        var last = 0
        val result = mutableListOf<Int>()
        for (i in s.indices) {
            last = maxOf(last, lookup.getValue(s[i]))
            if (i == last) {
                result.add(i - first + 1)
                first = i + 1
            }
        }
        return result.toIntArray()
    }
}
