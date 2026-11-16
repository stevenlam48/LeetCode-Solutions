package splitmessagebasedonlimit

// Time:  O(n + rlogr), r is the number of messages
// Space: O(1)

class Solution {
    fun splitMessage(message: String, limit: Int): List<String> {
        var cnt = 1
        var l = 1
        var total = message.length + 1
        var base = 1
        while (3 + l * 2 < limit) {
            if (total + (3 + l) * cnt <= limit * cnt) {
                break
            }
            ++cnt
            if (cnt == 10 * base) {
                ++l
                base *= 10
            }
            total += l
        }
        if (3 + l * 2 >= limit) {
            return emptyList()
        }
        val result = mutableListOf<String>()
        var j = 0
        for (i in 0 until cnt) {
            val length = limit - (3 + (i + 1).toString().length + cnt.toString().length)
            result.add(message.substring(j, minOf(j + length, message.length)) + "<${i + 1}/$cnt>")
            j += length
        }
        return result
    }
}
