package invalidtransactions

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    private class Trans(val name: String, val time: Int, val amount: Int, val city: String)

    fun invalidTransactions(transactions: Array<String>): List<String> {
        val AMOUNT = 1000
        val MINUTES = 60
        val trans = ArrayList<Trans>()
        for (transaction in transactions) {
            val t = split(transaction, ',')
            trans.add(Trans(t[0], t[1].toInt(), t[2].toInt(), t[3]))
        }
        trans.sortBy { it.time }
        val transIndexes = HashMap<String, MutableList<Int>>()
        for (i in trans.indices) {
            transIndexes.getOrPut(trans[i].name) { mutableListOf() }.add(i)
        }
        val result = mutableListOf<String>()
        for ((_, indexes) in transIndexes) {
            var left = 0
            var right = 0
            for (i in indexes.indices) {
                val t = trans[indexes[i]]
                if (t.amount > AMOUNT) {
                    result.add(toStr(t))
                    continue
                }
                while (left + 1 < indexes.size &&
                    trans[indexes[left]].time < t.time - MINUTES) {
                    ++left
                }
                while (right + 1 < indexes.size &&
                    trans[indexes[right + 1]].time <= t.time + MINUTES) {
                    ++right
                }
                for (k in left..right) {
                    if (trans[indexes[k]].city != t.city) {
                        result.add(toStr(t))
                        break
                    }
                }
            }
        }
        return result
    }

    private fun split(s: String, delim: Char): List<String> {
        val result = mutableListOf<String>()
        var end = -1
        do {
            val start = end + 1
            end = s.indexOf(delim, start)
            result.add(s.substring(start, if (end == -1) s.length else end))
        } while (end != -1)
        return result
    }

    private fun toStr(t: Trans): String = "${t.name},${t.time},${t.amount},${t.city}"
}
