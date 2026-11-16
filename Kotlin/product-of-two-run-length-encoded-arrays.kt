package productoftworunlengthencodedarrays

// Time:  O(m + n)
// Space: O(1)

class Solution {
    fun findRLEArray(encoded1: Array<IntArray>, encoded2: Array<IntArray>): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        var i = 0
        var j = 0
        var remain1 = 0
        var remain2 = 0
        while ((remain1 != 0 || i < encoded1.size) && (remain2 != 0 || j < encoded2.size)) {
            if (remain1 == 0) {
                remain1 = encoded1[i++][1]
            }
            if (remain2 == 0) {
                remain2 = encoded2[j++][1]
            }
            val cnt = minOf(remain1, remain2)
            remain1 -= cnt
            remain2 -= cnt
            val product = encoded1[i - 1][0] * encoded2[j - 1][0]
            if (result.isNotEmpty() && result.last()[0] == product) {
                result.last()[1] += cnt
            } else {
                result.add(intArrayOf(product, cnt))
            }
        }
        return result.toTypedArray()
    }
}
