package countpairsofsimilarstrings

// Time:  O(n * l)
// Space: O(n)

// freq table, bitmask
class Solution {
    fun similarPairs(words: List<String>): Int {
        var result = 0
        val cnt = HashMap<Int, Int>()
        for (w in words) {
            var mask = 0
            for (c in w) {
                mask = mask or (1 shl (c - 'a'))
            }
            result += cnt[mask] ?: 0
            cnt[mask] = (cnt[mask] ?: 0) + 1
        }
        return result
    }
}
