package minimizethemaximumoftwoarrays

// Time:  O(log(min(d1, d2)))
// Space: O(1)

class Solution {
    fun minimizeSet(divisor1: Int, divisor2: Int, uniqueCnt1: Int, uniqueCnt2: Int): Int {
        fun gcd(a: Long, b: Long): Long = if (b == 0L) a else gcd(b, a % b)
        fun count(cnt: Long, d1: Long, d2: Long): Long {
            val l = d1 / gcd(d1, d2) * d2
            return cnt + cnt / (l - 1) - if (cnt % (l - 1) == 0L) 1 else 0
        }
        return maxOf(
            count(uniqueCnt1.toLong(), divisor1.toLong(), 1L),
            count(uniqueCnt2.toLong(), divisor2.toLong(), 1L),
            count((uniqueCnt1 + uniqueCnt2).toLong(), divisor1.toLong(), divisor2.toLong())
        ).toInt()
    }
}
