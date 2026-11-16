package minimumintervalselectiontocovertargetintervals
// Time:  O(n + m + r)
// Space: O(r)

class Solution {
    fun minSelection(availableIntervals: Array<IntArray>, targetIntervals: Array<IntArray>): Int {
        val r = maxOf(
            availableIntervals.maxOf { it[1] },
            targetIntervals.maxOf { it[1] }
        )
        val diff = IntArray(2 * r + 2)
        for (x in targetIntervals) {
            val l = x[0]
            val right = x[1]
            ++diff[2 * l]
            --diff[2 * right + 1]
        }
        val lookup = IntArray(diff.size)
        for (x in availableIntervals) {
            val l = x[0]
            val right = x[1]
            lookup[2 * l] = maxOf(lookup[2 * l], 2 * right)
        }
        var result = 0
        var cnt = 0
        var reachable = 0
        var mx = 0
        for (i in diff.indices) {
            cnt += diff[i]
            mx = maxOf(mx, lookup[i])
            if (cnt == 0 || reachable >= i) {
                continue
            }
            if (mx < i) {
                return -1
            }
            reachable = mx
            ++result
        }
        return result
    }
}
