package flipgameii

// Time:  O(n + c^2), c is max length of consecutive '+'
// Space: O(c)

class Solution {
    fun canWin(s: String): Boolean {
        var gFinal = 0
        val g = mutableListOf<Int>()
        for (t in s.replace('-', ' ').split(' ')) {
            if (t.isEmpty()) {
                continue
            }
            val p = t.length
            while (g.size <= p) {
                val x = t.toCharArray()
                var i = 0
                var j = g.size - 2
                while (i <= j) {
                    x[g[i] xor g[j]] = '-'
                    i++
                    j--
                }
                g.add(x.indexOf('+'))
            }
            gFinal = gFinal xor g[p]
        }
        return gFinal != 0
    }
}
