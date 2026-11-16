package countpairsofequalsubstringswithminimumdifference

// Time:  O(n)
// Space: O(1)

class Solution {
    fun countQuadruples(firstString: String, secondString: String): Int {
        val lookup1 = IntArray(26) { -1 }
        for (i in firstString.length - 1 downTo 0) {
            lookup1[firstString[i] - 'a'] = i
        }
        val lookup2 = IntArray(26) { -1 }
        for (i in secondString.indices) {
            lookup2[secondString[i] - 'a'] = i
        }
        var result = 0
        var diff = Int.MAX_VALUE
        for (i in 0 until 26) {
            if (lookup1[i] == -1 || lookup2[i] == -1) {
                continue
            }
            if (lookup1[i] - lookup2[i] < diff) {
                diff = lookup1[i] - lookup2[i]
                result = 0
            }
            if (lookup1[i] - lookup2[i] == diff) {
                ++result
            }
        }
        return result
    }
}
