package maximumbitwisexorafterrearrangement

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maximumXor(s: String, t: String): String {
        val cnt = IntArray(2)
        cnt[0] = t.count { it == '0' }
        cnt[1] = t.length - cnt[0]
        val result = StringBuilder()
        for (c in s) {
            val x = c - '0'
            if (cnt[x xor 1] != 0) {
                --cnt[x xor 1]
                result.append('1')
            } else {
                --cnt[x]
                result.append('0')
            }
        }
        return result.toString()
    }
}
