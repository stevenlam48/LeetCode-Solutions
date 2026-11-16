package countingbits

// Time:  O(n)
// Space: O(n)

class Solution {
    fun countBits(num: Int): IntArray {
        val res = IntArray(num + 1)
        for (i in 1..num) {
            res[i] = (i and 1) + res[i shr 1]
        }
        return res
    }
}
