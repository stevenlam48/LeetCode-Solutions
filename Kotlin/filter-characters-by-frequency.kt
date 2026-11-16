package filtercharactersbyfrequency

// Time:  O(n + 26)
// Space: O(26)

class Solution {
    fun filterCharacters(s: String, k: Int): String {
        val cnt = IntArray(26)
        for (x in s) {
            ++cnt[x - 'a']
        }
        val result = StringBuilder()
        for (x in s) {
            if (cnt[x - 'a'] < k) {
                result.append(x)
            }
        }
        return result.toString()
    }
}
