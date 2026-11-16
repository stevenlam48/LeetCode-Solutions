package rearrangestringkdistanceapart

// Time:  O(n)
// Space: O(c)

class Solution {
    fun rearrangeString(s: String, k: Int): String {
        if (k == 0) {
            return s
        }
        if (s.isEmpty()) {
            return s
        }
        val cnts = HashMap<Char, Int>()
        for (c in s) {
            cnts[c] = (cnts[c] ?: 0) + 1
        }
        val bucketCnt = cnts.values.max()
        if (!((bucketCnt - 1) * k + cnts.values.count { it == bucketCnt } <= s.length)) {
            return ""
        }
        val partialSortedCnts = ArrayList<Char>()
        for ((c, v) in cnts) {
            if (v == bucketCnt) {
                partialSortedCnts.add(c)
            }
        }
        for ((c, v) in cnts) {
            if (v != bucketCnt) {
                partialSortedCnts.add(c)
            }
        }
        val result = CharArray(s.length)
        var i = (s.length - 1) % k
        for (c in partialSortedCnts) {
            repeat(cnts[c]!!) {
                result[i] = c
                i += k
                if (i >= result.size) {
                    i = (i - 1) % k
                }
            }
        }
        return String(result)
    }
}
