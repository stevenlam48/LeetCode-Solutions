package lexicographicallysmalleststringafterdeletingduplicatecharacters

// Time:  O(n + 26)
// Space: O(26)
class Solution {
    fun lexSmallestAfterDeletion(s: String): String {
        val counts = IntArray(26)
        for (char in s) {
            ++counts[char - 'a']
        }
        val result = StringBuilder()
        for (i in s.indices) {
            while (result.isNotEmpty() && result[result.length - 1] > s[i] &&
                counts[result[result.length - 1] - 'a'] != 1
            ) {
                --counts[result[result.length - 1] - 'a']
                result.deleteCharAt(result.length - 1)
            }
            result.append(s[i])
        }
        while (counts[result[result.length - 1] - 'a'] != 1) {
            --counts[result[result.length - 1] - 'a']
            result.deleteCharAt(result.length - 1)
        }
        return result.toString()
    }
}
