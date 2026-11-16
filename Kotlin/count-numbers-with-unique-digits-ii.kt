package countnumberswithuniquedigitsii

// Time:  O(logb)
// Space: O(1)
class Solution {
    fun numberCount(a: Int, b: Int): Int {
        fun count2(n: Int): Int {
            if (n == 0) {
                return 0
            }
            var result = 1
            var cnt = 1
            for (i in 0 until n - 1) {
                cnt *= 9 - i
                result += cnt
            }
            return 9 * result
        }

        fun count(x: Int): Int {
            var n = 1
            var base = 1
            while (x / (base * 10) != 0) {
                base *= 10
                ++n
            }
            var result = count2(n - 1)
            var lookup = 0
            var cnt = 1
            for (i in 0 until n - 1) {
                cnt *= 9 - i
            }
            for (i in 0 until n) {
                val d = (x / base) % 10
                val mask = lookup and ((1 shl d) - 1 - (if (i == 0) 1 else 0))
                result += (d - (if (i == 0) 1 else 0) - Integer.bitCount(mask)) * cnt
                cnt /= 9 - i
                if (lookup and (1 shl d) != 0) {
                    break
                }
                lookup = lookup or (1 shl d)
                base /= 10
            }
            return result
        }

        return count(b + 1) - count(a)
    }
}
