package processstringwithspecialoperationsi

// Time:  O(r), r = len(result)
// Space: O(r)

class Solution {
    fun processStr(s: String): String {
        val dq = ArrayDeque<Char>()
        var right = true
        for (x in s) {
            when (x) {
                '*' -> {
                    if (dq.isEmpty()) {
                        continue
                    }
                    if (right) {
                        dq.removeLast()
                    } else {
                        dq.removeFirst()
                    }
                }
                '#' -> {
                    val l = dq.size
                    for (i in 0 until l) {
                        dq.addLast(dq[i])
                    }
                }
                '%' -> right = !right
                else -> {
                    if (right) {
                        dq.addLast(x)
                    } else {
                        dq.addFirst(x)
                    }
                }
            }
        }
        if (!right) {
            return dq.reversed().joinToString("")
        }
        return dq.joinToString("")
    }
}
