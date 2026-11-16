package theemployeethatworkedonthelongesttask
// Time:  O(l)
// Space: O(1)

class Solution {
    fun hardestWorker(n: Int, logs: Array<IntArray>): Int {
        var result = -1
        var prev = 0
        var t = 0
        for (log in logs) {
            if (log[1] - prev > t) {
                t = log[1] - prev
                result = log[0]
            } else if (log[1] - prev == t && log[0] < result) {
                result = log[0]
            }
            prev = log[1]
        }
        return result
    }
}
