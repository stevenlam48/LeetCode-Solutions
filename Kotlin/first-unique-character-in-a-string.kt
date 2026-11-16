package firstuniquecharacterinastring

// Time:  O(n)
// Space: O(n)

class Solution {
    fun firstUniqChar(s: String): Int {
        val candidates = LinkedHashMap<Char, Int>()
        val seen = HashSet<Char>()
        for (i in s.indices) {
            val c = s[i]
            if (c in seen) {
                candidates.remove(c)
            } else {
                seen.add(c)
                candidates[c] = i
            }
        }
        return candidates.values.firstOrNull() ?: -1
    }
}
