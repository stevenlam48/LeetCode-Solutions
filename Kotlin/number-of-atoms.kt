package numberofatoms

import java.util.TreeMap

// Time:  O(n)
// Space: O(n)

class Solution {
    fun countOfAtoms(formula: String): String {
        val stk = ArrayDeque<TreeMap<String, Int>>()
        stk.addLast(TreeMap())
        val e = Regex("([A-Z][a-z]*)(\\d*)|(\\()|(\\))(\\d*)")
        for (match in e.findAll(formula)) {
            val name = match.groupValues[1]
            val m1 = match.groupValues[2]
            val leftOpen = match.groupValues[3]
            val rightOpen = match.groupValues[4]
            val m2 = match.groupValues[5]
            if (name.isNotEmpty()) {
                val top = stk.last()
                top[name] = (top[name] ?: 0) + (if (m1.isNotEmpty()) m1.toInt() else 1)
            }
            if (leftOpen.isNotEmpty()) {
                stk.addLast(TreeMap())
            }
            if (rightOpen.isNotEmpty()) {
                val top = stk.removeLast()
                val parent = stk.last()
                val mult = if (m2.isNotEmpty()) m2.toInt() else 1
                for ((key, value) in top) {
                    parent[key] = (parent[key] ?: 0) + value * mult
                }
            }
        }
        val result = StringBuilder()
        for ((key, value) in stk.last()) {
            result.append(key)
            if (value > 1) {
                result.append(value)
            }
        }
        return result.toString()
    }
}
