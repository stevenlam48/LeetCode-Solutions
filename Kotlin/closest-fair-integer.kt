package closestfairinteger

// Time:  O(logn)
// Space: O(logn)

class Solution {
    fun closestFair(n: Int): Int {
        val digits = n.toString()
        val result = StringBuilder()
        if (digits.length % 2 == 0) {
            val left = IntArray(2)
            for (d in digits) {
                ++left[(d - '0') % 2]
            }
            if (left[0] == digits.length / 2) {
                return n
            }
            for (i in digits.length - 1 downTo digits.length / 2) {
                --left[(digits[i] - '0') % 2]
                val right = intArrayOf(digits.length / 2 - left[0], digits.length / 2 - left[1])
                if (right.any { it < 0 }) {
                    continue
                }
                val d = if (right[((digits[i] + 1) - '0') % 2] - 1 >= 0) {
                    digits[i] + 1
                } else {
                    digits[i] + 2
                }
                if (d > '9') {
                    continue
                }
                --right[(d - '0') % 2]
                result.append(digits, 0, i)
                result.append(d)
                result.append("0".repeat(right[0]))
                result.append("1".repeat(right[1]))
                break
            }
        }
        if (result.isEmpty()) {
            val l = digits.length / 2 + 1
            result.append('1')
            result.append("0".repeat(l))
            result.append("1".repeat(l - 1))
        }
        return result.toString().toInt()
    }
}
