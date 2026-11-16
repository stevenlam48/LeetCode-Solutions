package baseballgame

// Time:  O(n)
// Space: O(n)

class Solution {
    fun calPoints(ops: List<String>): Int {
        val records = mutableListOf<Int>()
        for (op in ops) {
            when (op) {
                "+" -> records.add(records[records.size - 2] + records.last())
                "D" -> records.add(2 * records.last())
                "C" -> records.removeAt(records.lastIndex)
                else -> records.add(op.toInt())
            }
        }
        return records.sum()
    }
}
