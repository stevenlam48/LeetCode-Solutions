package designexcelsumformula

// Time:  set: O((r * c)^2)
//        get: O(1)
//        sum: O((r * c)^2)
// Space: O(r * c)
import java.util.ArrayDeque

class Excel(H: Int, W: Char) {
    private val cells = Array(H + 1) { IntArray(W - 'A' + 1) }
    private val forward = HashMap<Int, HashMap<Int, Int>>()
    private val backward = HashMap<Int, HashSet<Int>>()

    fun set(r: Int, c: Char, v: Int) {
        val col = c - 'A'
        resetDependency(r, col)
        updateOthers(r, col, v)
    }

    fun get(r: Int, c: Char): Int = cells[r][c - 'A']

    fun sum(r: Int, c: Char, strs: List<String>): Int {
        val col = c - 'A'
        resetDependency(r, col)
        val result = calcAndUpdateDependency(r, col, strs)
        updateOthers(r, col, result)
        return result
    }

    private fun resetDependency(r: Int, col: Int) {
        val key = r * 26 + col
        backward.remove(key)?.forEach { dependency ->
            forward[dependency]?.remove(key)
        }
    }

    private fun calcAndUpdateDependency(r: Int, col: Int, strs: List<String>): Int {
        var result = 0
        for (s in strs) {
            val p = s.indexOf(':')
            val left = s[0] - 'A'
            val right = if (p == -1) left else s[p + 1] - 'A'
            val top = if (p == -1) s.substring(1).toInt() else s.substring(1, p).toInt()
            val bottom = if (p == -1) top else s.substring(p + 2).toInt()
            for (i in top..bottom) {
                for (j in left..right) {
                    result += cells[i][j]
                    val source = i * 26 + j
                    val target = r * 26 + col
                    val dependents = forward.getOrPut(source) { HashMap() }
                    dependents[target] = dependents.getOrDefault(target, 0) + 1
                    backward.getOrPut(target) { HashSet() }.add(source)
                }
            }
        }
        return result
    }

    private fun updateOthers(r: Int, col: Int, v: Int) {
        val previous = cells[r][col]
        cells[r][col] = v
        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.addLast((r * 26 + col) to (v - previous))
        while (queue.isNotEmpty()) {
            val (key, difference) = queue.removeFirst()
            forward[key]?.forEach { (dependent, count) ->
                queue.addLast(dependent to (difference * count))
                cells[dependent / 26][dependent % 26] += difference * count
            }
        }
    }
}
