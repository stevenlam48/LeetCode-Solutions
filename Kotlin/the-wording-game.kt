package thewordinggame
// Time:  O(m + n), m = sum(len(w) for w in a), n = sum(len(w) for w in b)
// Space: O(1)

class Solution {
    fun canAliceWin(a: List<String>, b: List<String>): Boolean {
        fun isCloselyGreater(x: String, y: String): Boolean {
            return x[0] - y[0] <= 1 && x > y
        }

        var result = true
        var i = 0
        var j = -1
        val alphabet1 = a.mapTo(HashSet()) { it[0] }
        val alphabet2 = b.mapTo(HashSet()) { it[0] }
        val turn = alphabet1.size + alphabet2.size
        var currentA = a
        var currentB = b
        repeat(turn) {
            ++j
            while (j < currentB.size && !isCloselyGreater(currentB[j], currentA[i])) {
                ++j
            }
            if (j == currentB.size) {
                return result
            }
            while (j + 1 < currentB.size && currentB[j + 1][0] == currentB[j][0]) {
                ++j
            }
            val words = currentA
            currentA = currentB
            currentB = words
            val index = i
            i = j
            j = index
            result = !result
        }
        return result
    }
}
