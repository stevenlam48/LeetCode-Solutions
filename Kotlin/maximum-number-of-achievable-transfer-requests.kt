package maximumnumberofachievabletransferrequests

// Time:  O((n + r) * 2^r)
// Space: O(n + r)

class Solution {
    fun maximumRequests(n: Int, requests: Array<IntArray>): Int {
        val check = { idx: IntArray ->
            val change = IntArray(n)
            for (i in idx) {
                --change[requests[i][0]]
                ++change[requests[i][1]]
            }
            change.all { it == 0 }
        }

        for (k in requests.size downTo 1) {
            if (combinations(requests.size, k, check)) {
                return k
            }
        }
        return 0
    }

    private fun combinations(n: Int, k: Int, callback: (IntArray) -> Boolean): Boolean {
        val idxs = IntArray(k) { it }
        if (callback(idxs)) {
            return true
        }
        while (true) {
            var i = k - 1
            while (i >= 0) {
                if (idxs[i] != i + n - k) {
                    break
                }
                --i
            }
            if (i < 0) {
                return false
            }
            ++idxs[i]
            for (j in i + 1 until k) {
                idxs[j] = idxs[j - 1] + 1
            }
            if (callback(idxs)) {
                return true
            }
        }
    }
}
