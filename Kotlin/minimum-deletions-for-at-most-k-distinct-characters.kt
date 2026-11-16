package minimumdeletionsforatmostkdistinctcharacters

// Time:  O(n + 26)
// Space: O(n + 26)

class Solution {
    fun minDeletion(s: String, k: Int): Int {
        val cnt = IntArray(26)
        for (x in s) {
            ++cnt[x - 'a']
        }
        val cnt2 = IntArray(cnt.max() + 1)
        for (x in cnt) {
            ++cnt2[x]
        }
        var result = 0
        var total = 26 - k
        for (i in cnt2.indices) {
            val c = minOf(cnt2[i], total)
            result += i * c
            total -= c
            if (total == 0) {
                break
            }
        }
        return result
    }
}
