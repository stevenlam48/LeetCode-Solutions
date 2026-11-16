package findmostfrequentvowelandconsonant

// Time:  O(n + 26)
// Space: O(26)

class Solution {
    fun maxFreqSum(s: String): Int {
        val vowels = setOf('a', 'e', 'i', 'o', 'u')
        val cnt = IntArray(26)
        for (x in s) {
            ++cnt[x - 'a']
        }
        var mx1 = 0
        var mx2 = 0
        for (i in cnt.indices) {
            if ('a' + i in vowels) {
                mx1 = maxOf(mx1, cnt[i])
            } else {
                mx2 = maxOf(mx2, cnt[i])
            }
        }
        return mx1 + mx2
    }
}
