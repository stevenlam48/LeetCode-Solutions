package findklengthsubstringswithnorepeatedcharacters
// Time:  O(n)
// Space: O(k)

class Solution {
    fun numKLenSubstrNoRepeats(s: String, k: Int): Int {
        var result = 0
        var i = 0
        val lookup = HashSet<Char>()
        for (j in s.indices) {
            while (lookup.contains(s[j])) {
                lookup.remove(s[i])
                ++i
            }
            lookup.add(s[j])
            if (j - i + 1 >= k) {
                ++result
            }
        }
        return result
    }
}
