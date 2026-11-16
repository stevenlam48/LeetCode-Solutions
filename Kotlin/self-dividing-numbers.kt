package selfdividingnumbers

// Time:  O(nlogr) = O(n)
// Space: O(logr) = O(1)

class Solution {
    fun selfDividingNumbers(left: Int, right: Int): IntArray {
        val result = ArrayList<Int>()
        for (i in left..right) {
            if (isDividingNumber(i)) {
                result.add(i)
            }
        }
        return result.toIntArray()
    }

    private fun isDividingNumber(num: Int): Boolean {
        var n = num
        while (n > 0) {
            val digit = n % 10
            if (digit == 0 || num % digit != 0) {
                return false
            }
            n /= 10
        }
        return true
    }
}
