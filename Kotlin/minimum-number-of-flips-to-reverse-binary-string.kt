package minimumnumberofflipstoreversebinarystring

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun minimumFlips(n: Int): Int {
        val x = n.toLong()
        val bitLength = if (x != 0L) 64 - java.lang.Long.numberOfLeadingZeros(x) else 0
        val l = bitLength
        var result = 0
        for (i in 0 until l / 2) {
            if (((x shr i) and 1L) != ((x shr ((l - 1) - i)) and 1L)) {
                result += 2
            }
        }
        return result
    }
}
