package romantointeger

// Time:  O(n)
// Space: O(1)

class Solution {
    fun romanToInt(s: String): Int {
        val numeralMap = mapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000
        )
        var decimal = 0
        for (i in s.indices) {
            if (i > 0 && numeralMap.getValue(s[i]) > numeralMap.getValue(s[i - 1])) {
                decimal += numeralMap.getValue(s[i]) - 2 * numeralMap.getValue(s[i - 1])
            } else {
                decimal += numeralMap.getValue(s[i])
            }
        }
        return decimal
    }
}
