package countmentionsperuser

// Time:  O(eloge + e * n), e = len(events)
// Space: O(e + n)

// simulation
class Solution {
    fun countMentions(numberOfUsers: Int, events: Array<Array<String>>): IntArray {
        val result = IntArray(numberOfUsers)
        val lookup = IntArray(numberOfUsers) { 1 }
        events.sortWith(compareBy({ it[1].toInt() }, { if (it[0] == "MESSAGE") 1 else 0 }))

        for (e in events) {
            if (e[0] == "OFFLINE") {
                lookup[e[2].toInt()] = e[1].toInt() + 60
                continue
            }
            if (e[2] == "ALL") {
                for (i in result.indices) {
                    ++result[i]
                }
            } else if (e[2] == "HERE") {
                for (i in result.indices) {
                    if (lookup[i] <= e[1].toInt()) {
                        ++result[i]
                    }
                }
            } else {
                var j = 0
                for (i in e[2].indices) {
                    if (i + 1 == e[2].length || e[2][i + 1] == ' ') {
                        ++result[e[2].substring(j + 2, i + 1).toInt()]
                        j = i + 2
                    }
                }
            }
        }
        return result
    }
}
