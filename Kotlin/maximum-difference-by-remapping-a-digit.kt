package maximumdifferencebyremappingadigit
// Time:  O(logn)
// Space: O(1)

class Solution {
    fun minMaxDifference(num: Int): Int {
        fun f(dst: Int): Int {
            var result = 0
            var base = 1
            while (base <= num) {
                base *= 10
            }
            base /= 10
            var src = -1
            while (base != 0) {
                val d = num / base % 10
                if (src == -1 && d != dst) {
                    src = d
                }
                result += base * if (d == src) dst else d
                base /= 10
            }
            return result
        }
        return f(9) - f(0)
    }
}
