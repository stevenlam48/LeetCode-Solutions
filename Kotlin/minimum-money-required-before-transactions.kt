package minimummoneyrequiredbeforetransactions

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minimumMoney(transactions: Array<IntArray>): Long {
        var result = 0L
        var last = 0L
        for (t in transactions) {
            last = maxOf(last, (t[0] - maxOf(t[0] - t[1], 0)).toLong())
            result += maxOf(t[0] - t[1], 0)
        }
        result += last
        return result
    }
}
