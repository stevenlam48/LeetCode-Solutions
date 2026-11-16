package integertoroman
// Time:  O(n)
// Space: O(1)

class Solution {
    fun intToRoman(num: Int): String {
        val nums = intArrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
        val romans = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
        val result = StringBuilder()
        var value = num
        var i = 0
        while (value > 0) {
            var times = value / nums[i]
            while (times-- > 0) {
                value -= nums[i]
                result.append(romans[i])
            }
            ++i
        }
        return result.toString()
    }
}
