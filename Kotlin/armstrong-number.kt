package armstrongnumber

// Time:  O(klogk)
// Space: O(k)

class Solution {
    fun isArmstrong(N: Int): Boolean {
        val nStr = N.toString()
        return nStr.fold(0) { acc, c ->
            acc + Math.pow((c - '0').toDouble(), nStr.length.toDouble()).toInt()
        } == N
    }
}
