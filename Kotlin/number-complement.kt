package numbercomplement

// Time:  O(1)
// Space: O(1)

class Solution {
    fun findComplement(num: Int): Int {
        var i = 1L
        while (i <= num) {
            i = i shl 1
        }
        return ((i - 1) xor num.toLong()).toInt()
    }
}
