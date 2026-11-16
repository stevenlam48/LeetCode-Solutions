package maxdifferenceyoucangetfromchanginganinteger

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun maxDiff(num: Int): Int {
        fun find(value: Int, check: (Int) -> Boolean): Int {
            var current = value
            var result = 0
            while (current != 0) {
                val d = current % 10
                if (check(d)) {
                    result = d
                }
                current /= 10
            }
            return result
        }

        fun reverse(value: Int, length: Int): Int {
            var current = value
            var l = length
            var result = 0
            while (current != 0 || l > 0) {
                result = result * 10 + current % 10
                current /= 10
                l--
            }
            return result
        }

        fun replace(value: Int, x: Int, y: Int): Int {
            var current = value
            var l = 0
            var result = 0
            while (current != 0) {
                var d = current % 10
                if (d == x) {
                    d = y
                }
                result = result * 10 + d
                current /= 10
                l++
            }
            return reverse(result, l)
        }

        val b = find(num) { it < 9 }
        val a = find(num) { it > 1 }
        return replace(num, b, 9) - replace(num, a, if (reverse(num, 0) % 10 != 1) 1 else 0)
    }
}
