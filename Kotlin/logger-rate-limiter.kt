package loggerratelimiter

// Time:  O(1), amortized
// Space: O(k), k is the max number of printed messages in last 10 seconds

import java.util.ArrayDeque

class Logger {
    private val dq = ArrayDeque<Pair<Int, String>>()
    private val printed = HashSet<String>()

    fun shouldPrintMessage(timestamp: Int, message: String): Boolean {
        while (dq.isNotEmpty() && dq.first().first <= timestamp - 10) {
            printed.remove(dq.first().second)
            dq.removeFirst()
        }
        if (printed.contains(message)) {
            return false
        }
        dq.addLast(timestamp to message)
        printed.add(message)
        return true
    }
}
