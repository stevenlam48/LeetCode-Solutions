package earliesttimetofinishonetask

// Time:  O(n)
// Space: O(1)

// array
class Solution {
    fun earliestTime(tasks: Array<IntArray>): Int {
        val it = tasks.minByOrNull { it[0] + it[1] }!!
        return it[0] + it[1]
    }
}
