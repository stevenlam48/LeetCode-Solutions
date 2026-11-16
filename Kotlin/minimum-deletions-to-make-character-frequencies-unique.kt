package minimumdeletionstomakecharacterfrequenciesunique
// Time:  O(n)
// Space: O(1)

class Solution {
    fun minDeletions(s: String): Int {
        val count = IntArray(26)
        for (c in s) {
            ++count[c - 'a']
        }
        val lookup = HashSet<Int>()
        var result = 0
        for (i in 0 until 26) {
            for (c in count[i] downTo 1) {
                if (lookup.add(c)) {
                    break
                }
                ++result
            }
        }
        return result
    }
}
