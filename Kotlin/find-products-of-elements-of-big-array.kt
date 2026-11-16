package findproductsofelementsofbigarray

// Time:  O(q * (logr)^2)
// Space: O(1)

// binary search, combinatorics, bitmasks, fast exponentiation
class Solution {
    fun findProductsOfElements(queries: Array<LongArray>): IntArray {
        fun binarySearch(left: Long, right: Long, check: (Long) -> Boolean): Long {
            var l = left
            var r = right
            while (l <= r) {
                val mid = l + ((r - l) / 2)
                if (check(mid)) {
                    r = mid - 1
                } else {
                    l = mid + 1
                }
            }
            return l
        }

        fun powmod(a0: Long, b0: Long, mod: Int): Int {
            var a = a0 % mod
            var b = b0
            var result = 1L % mod
            while (b > 0) {
                if ((b and 1L) != 0L) {
                    result = result * a % mod
                }
                a = a * a % mod
                b = b shr 1
            }
            return result.toInt()
        }

        fun count1(x: Long): Long {
            var result = 0L
            var i = 0
            while ((1L shl i) <= x) {
                val mask = (1L shl (i + 1)) - 1
                result += ((x and mask.inv()) shr 1) + maxOf((x and mask) - (1L shl i) + 1, 0L)
                ++i
            }
            return result
        }

        fun count2(x: Long): Long {
            var result = 0L
            var i = 0
            while ((1L shl i) <= x) {
                val mask = (1L shl (i + 1)) - 1
                result += (((x and mask.inv()) shr 1) + maxOf((x and mask) - (1L shl i) + 1, 0L)) * i
                ++i
            }
            return result
        }

        fun f(x0: Long): Long {
            var x = x0
            val y = binarySearch(1L, x - 1) { i -> count1(i) >= x }
            var result = count2(y - 1)
            x -= count1(y - 1)
            var i = 0
            while ((1L shl i) <= y) {
                if ((y and (1L shl i)) == 0L) {
                    ++i
                    continue
                }
                result += i
                if (--x == 0L) {
                    break
                }
                ++i
            }
            return result
        }

        val result = IntArray(queries.size)
        for (i in queries.indices) {
            val left = queries[i][0]
            val right = queries[i][1]
            val mod = queries[i][2].toInt()
            result[i] = powmod(2L, f(right + 1) - f(left), mod)
        }
        return result
    }
}
