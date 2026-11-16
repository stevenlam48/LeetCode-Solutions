package minimizexor

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun minimizeXor(num1: Int, num2: Int): Int {
        val cnt1 = Integer.bitCount(num1)
        val cnt2 = Integer.bitCount(num2)
        var result = num1
        var cnt = Math.abs(cnt1 - cnt2)
        val expect = if (cnt1 >= cnt2) 1 else 0
        var i = 0
        while (cnt > 0) {
            if (((num1 shr i) and 1) == expect) {
                --cnt
                result = result xor (1 shl i)
            }
            ++i
        }
        return result
    }
}
