package largestnumberafterdigitswapsbyparity

// Time:  O(logn)
// Space: O(1)

// counting sort
class Solution {
    fun largestInteger(num: Int): Int {
        fun count(n: Int): IntArray {
            val cnt = IntArray(10)
            var x = n
            while (x != 0) {
                ++cnt[x % 10]
                x /= 10
            }
            return cnt
        }

        val cnt = count(num)
        var result = 0L
        val digit = intArrayOf(0, 1)
        var n = num
        var base = 1L
        while (n != 0) {
            val parity = (n % 10) % 2
            while (cnt[digit[parity]] == 0) {
                digit[parity] += 2
            }
            --cnt[digit[parity]]
            result += digit[parity] * base
            n /= 10
            base *= 10
        }
        return result.toInt()
    }
}
