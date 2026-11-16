package majorityfrequencycharacters

// Time:  O(n + 26)
// Space: O(26)

class Solution {
    fun majorityFrequencyGroup(s: String): String {
        val cnt = HashMap<Char, Int>()
        for (x in s) {
            cnt[x] = cnt.getOrDefault(x, 0) + 1
        }
        val cnt2 = HashMap<Int, StringBuilder>()
        for ((x, c) in cnt) {
            cnt2.getOrPut(c) { StringBuilder() }.append(x)
        }
        var k = 0
        for ((c, group) in cnt2) {
            if (k == 0 || cnt2.getValue(k).length < group.length ||
                cnt2.getValue(k).length == group.length && k < c
            ) {
                k = c
            }
        }
        return cnt2[k]?.toString().orEmpty()
    }
}
