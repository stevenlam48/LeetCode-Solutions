package minimumlevelstogainmorepoints

// Time:  O(n)
// Space: O(n)

class Solution {
    fun minimumLevels(possible: IntArray): Int {
        val prefix = IntArray(possible.size + 1)
        for (i in possible.indices) {
            prefix[i + 1] = prefix[i] + if (possible[i] != 0) 1 else -1
        }
        for (i in possible.indices) {
            if (i + 1 < possible.size) {
                if (prefix[i + 1] > prefix[possible.size] - prefix[i + 1]) {
                    return i + 1
                }
            }
        }
        return -1
    }
}
