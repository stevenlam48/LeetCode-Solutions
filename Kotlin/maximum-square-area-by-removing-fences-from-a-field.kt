package maximumsquareareabyremovingfencesfromafield

// Time:  O(h^2 + v^2)
// Space: O(min(h, v)^2)

class Solution {
    fun maximizeSquareArea(m0: Int, n0: Int, hFences: IntArray, vFences: IntArray): Int {
        val mod = 1_000_000_007
        var m = m0
        var n = n0
        var h = hFences
        var v = vFences
        if (h.size > v.size) {
            val t = h
            h = v
            v = t
            val t2 = m
            m = n
            n = t2
        }
        val lookup = HashSet<Long>()
        var result = -1L
        fun diff(arr: IntArray, x: Int, check: Boolean) {
            val a = ArrayList<Int>(arr.size + 2)
            for (e in arr) {
                a.add(e)
            }
            a.add(1)
            a.add(x)
            for (i in a.indices) {
                for (j in i + 1 until a.size) {
                    val d = Math.abs(a[i] - a[j]).toLong()
                    if (!check) {
                        lookup.add(d)
                    } else if (d in lookup) {
                        result = maxOf(result, d * d)
                    }
                }
            }
        }
        diff(h, m, false)
        diff(v, n, true)
        return (result % mod).toInt()
    }
}
