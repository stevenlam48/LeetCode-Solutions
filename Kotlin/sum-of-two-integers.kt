package sumoftwointegers

// Time:  O(1)
// Space: O(1)

class Solution {
    fun getSum(a: Int, b: Int): Int {
        var x = a
        var y = b
        while (y != 0) {
            val carry = x and y
            x = x xor y
            y = carry shl 1
        }
        return x
    }
}
