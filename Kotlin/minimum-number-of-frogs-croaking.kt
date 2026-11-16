package minimumnumberoffrogscroaking

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minNumberOfFrogs(croakOfFrogs: String): Int {
        val s = "croak"
        val lookup = IntArray(5)
        var result = 0
        for (c in croakOfFrogs) {
            val i = s.indexOf(c)
            ++lookup[i]
            if (lookup[(i - 1 + lookup.size) % lookup.size] != 0) {
                --lookup[(i - 1 + lookup.size) % lookup.size]
            } else if (i == 0) {
                ++result
            } else {
                return -1
            }
        }
        return if (result == lookup[lookup.size - 1]) result else -1
    }
}
