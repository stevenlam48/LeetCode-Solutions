package exclusivetimeoffunctions

// Time:  O(n)
// Space: O(n)

import java.util.ArrayDeque

class Solution {
    fun exclusiveTime(n: Int, logs: List<String>): IntArray {
        val result = IntArray(n)
        val stk = ArrayDeque<Int>()
        var prev = 0
        for (log in logs) {
            val tokens = log.split(':')
            if (tokens[1] == "start") {
                if (!stk.isEmpty()) {
                    result[stk.peek()] += tokens[2].toInt() - prev
                }
                stk.push(tokens[0].toInt())
                prev = tokens[2].toInt()
            } else {
                result[stk.peek()] += tokens[2].toInt() - prev + 1
                stk.pop()
                prev = tokens[2].toInt() + 1
            }
        }
        return result
    }
}
