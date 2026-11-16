package minimumnumberoflinestocoverpoints

// Time:  O(n^2 + n*2^n) = O(n*2^n)
// Space: O(n^2)

// math, hash table, bitmasks
class Solution {
    fun minimumLines(points: Array<IntArray>): Int {
        fun ceilDivide(a: Int, b: Int): Int = (a + b - 1) / b

        val lookup = HashMap<Triple<Int, Int, Int>, HashSet<Pair<Int, Int>>>()
        for (i in points.indices) {
            val x1 = points[i][0]
            val y1 = points[i][1]
            for (j in i + 1 until points.size) {
                val x2 = points[j][0]
                val y2 = points[j][1]
                // (x-x1)/(x2-x1) = (y-y1)/(y2-y1)
                // => (y2-y1)x - (x2-x1)y = x1(y2-y1) - y1(x2-x1)
                val dx = x2 - x1
                val dy = y2 - y1
                val g = gcd(dx, dy)
                var a = dx / g
                var b = dy / g
                if (a < 0 || (a == 0 && b < 0)) {
                    a = -a
                    b = -b
                }
                val c = b * x1 - a * y1
                val key = Triple(a, b, c)
                lookup.getOrPut(key) { HashSet() }.add(Pair(x1, y1))
                lookup.getOrPut(key) { HashSet() }.add(Pair(x2, y2))
            }
        }
        val lines = ArrayList<Triple<Int, Int, Int>>()
        for ((l, p) in lookup) {
            if (p.size > 2) {  // filter to improve complexity
                lines.add(l)
            }
        }
        var result = Int.MAX_VALUE
        val maskUpperBound = 1 shl lines.size
        for (mask in 0 until maskUpperBound) {
            val covered = HashSet<Pair<Int, Int>>()
            for (i in lines.indices) {
                if ((mask shr i) and 1 != 0) {
                    covered.addAll(lookup[lines[i]]!!)
                }
            }
            result = minOf(result, Integer.bitCount(mask) + ceilDivide(points.size - covered.size, 2))
        }
        return result
    }

    private fun gcd(a: Int, b: Int): Int {
        var x = Math.abs(a)
        var y = Math.abs(b)
        while (y != 0) {
            val t = x % y
            x = y
            y = t
        }
        return x
    }
}
