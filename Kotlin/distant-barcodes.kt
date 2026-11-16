package distantbarcodes

// Time:  O(n), k is the number of distinct barcode
// Space: O(k)

class Solution {
    fun rearrangeBarcodes(barcodes: IntArray): IntArray {
        val k = 2

        val cnts = HashMap<Int, Int>()
        for (c in barcodes) {
            cnts.merge(c, 1, Int::plus)
        }
        val bucketCnt = cnts.values.max()
        val partialSortedCnts = mutableListOf<Int>()
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
        val result = IntArray(barcodes.size)
        var i = (barcodes.size - 1) % k
        for (c in partialSortedCnts) {
            repeat(cnts[c]!!) {
                result[i] = c
                i += k
                if (i >= result.size) {
                    i = (i - 1) % k
                }
            }
        }
        return result
    }
}
