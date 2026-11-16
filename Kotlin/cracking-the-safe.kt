package crackingthesafe

// Time:  O(k^n)
// Space: O(k^n)

class Solution {
    fun crackSafe(n: Int, k: Int): String {
        val m = Math.pow(k.toDouble(), (n - 1).toDouble()).toInt()
        val p = mutableListOf<Int>()
        for (i in 0 until k) {
            for (q in 0 until m) {
                p.add(q * k + i)
            }
        }
        val total = Math.pow(k.toDouble(), n.toDouble()).toInt()
        val result = StringBuilder((('0'.code + k - 1).toChar()).toString().repeat(n - 1))
        for (i in 0 until total) {
            var j = i
            while (p[j] >= 0) {
                result.append(('0'.code + j / m).toChar())
                val pj = p[j]
                p[j] = -1
                j = pj
            }
        }
        return result.toString()
    }
}
