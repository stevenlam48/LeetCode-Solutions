package removelettertoequalizefrequency

// Time:  O(n)
// Space: O(1)
class Solution {
    fun equalFrequency(word: String): Boolean {
        val cnt = IntArray(26)
        for (c in word) {
            ++cnt[c - 'a']
        }
        val cnt2 = HashMap<Int, Int>()
        for (c in cnt) {
            if (c != 0) {
                cnt2[c] = (cnt2[c] ?: 0) + 1
            }
        }
        if (cnt2.size > 2) {
            return false
        }
        if (cnt2.size == 1) {
            val entry = cnt2.entries.first()
            return entry.key == 1 || entry.value == 1
        }
        val it = cnt2.keys.iterator()
        var a = it.next()
        var b = it.next()
        if (a > b) {
            val tmp = a
            a = b
            b = tmp
        }
        return (a == 1 && cnt2[a] == 1) || (a + 1 == b && cnt2[b] == 1)
    }
}
