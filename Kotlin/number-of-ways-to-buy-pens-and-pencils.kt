package numberofwaystobuypensandpencils

// Time:  O(min(t / c1, c2 / g)) = O(sqrt(t)), c1 = max(cost1, cost2)
//                                           , c2 = min(cost1, cost2)
//                                           ,  g = gcd(c1, c2)
// Space: O(1)

class Solution {
    fun waysToBuyPensPencils(total: Int, cost1: Int, cost2: Int): Long {
        var c1 = cost1
        var c2 = cost2
        if (c1 < c2) {
            val tmp = c1
            c1 = c2
            c2 = tmp
        }
        val lcm = c1.toLong() / gcd(c1, c2) * c2
        val d = lcm / c2
        var result = 0L
        val limit = minOf(total / c1, (lcm / c1).toInt() - 1)
        for (i in 0..limit) {
            val cnt = ((total - i * c1) / c2 + 1).toLong()
            val l = (cnt + d - 1) / d
            result += (cnt + (cnt + (l - 1) * -d)) * l / 2
        }
        return result
    }

    private fun gcd(a: Int, b: Int): Int {
        var x = a
        var y = b
        while (y != 0) {
            val t = x % y
            x = y
            y = t
        }
        return x
    }
}
