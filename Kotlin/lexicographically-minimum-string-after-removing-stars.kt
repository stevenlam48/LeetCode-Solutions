package lexicographicallyminimumstringafterremovingstars

// Time:  O(n + 26)
// Space: O(n + 26)

class Solution {
    fun clearStars(s: String): String {
        val chars = s.toCharArray()
        val lookup = Array(26) { ArrayList<Int>() }
        for (i in chars.indices) {
            if (chars[i] != '*') {
                lookup[chars[i] - 'a'].add(i)
                continue
            }
            for (stk in lookup) {
                if (stk.isEmpty()) {
                    continue
                }
                chars[stk.removeAt(stk.size - 1)] = '*'
                break
            }
        }
        return String(chars.filter { it != '*' }.toCharArray())
    }
}
