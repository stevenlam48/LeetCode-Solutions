package groupsofspecialequivalentstrings

// Time:  O(n * l)
// Space: O(n)

class Solution {
    fun numSpecialEquivGroups(A: List<String>): Int {
        val lookup = HashSet<List<Int>>()
        for (s in A) {
            val count = IntArray(52)
            for (i in s.indices) {
                ++count[s[i] - 'a' + 26 * (i % 2)]
            }
            lookup.add(count.toList())
        }
        return lookup.size
    }
}
