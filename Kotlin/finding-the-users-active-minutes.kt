package findingtheusersactiveminutes
// Time:  O(n)
// Space: O(n)

class Solution {
    fun findingUsersActiveMinutes(logs: Array<IntArray>, k: Int): IntArray {
        val lookup = HashMap<Int, MutableSet<Int>>()
        for (log in logs) {
            lookup.getOrPut(log[0]) { mutableSetOf() }.add(log[1])
        }
        val result = IntArray(k)
        for (ts in lookup.values) {
            ++result[ts.size - 1]
        }
        return result
    }
}
