package swapadjacentinlrstring

// Time:  O(n)
// Space: O(1)

// the following are invariant if the number of 'X' in both strings are the same
// 1. the ordering of 'L', 'R' in both strings are the same
// 2. for each position (i, j) of paired 'L' character in both strings, i >= j
// 3. for each position (i, j) of paired 'R' character in both strings, i <= j
class Solution {
    fun canTransform(start: String, end: String): Boolean {
        var count = 0
        for (i in start.indices) {
            if (start[i] == 'X') {
                ++count
            }
            if (end[i] == 'X') {
                --count
            }
        }
        if (count != 0) {
            return false
        }
        var i = 0
        var j = 0
        while (i < start.length && j < end.length) {
            while (i < start.length && start[i] == 'X') {
                ++i
            }
            while (j < end.length && end[j] == 'X') {
                ++j
            }
            if ((i < start.length) != (j < end.length)) {
                return false
            }
            if (i < start.length && j < end.length) {
                if (start[i] != end[j] ||
                    (start[i] == 'L' && i < j) ||
                    (start[i] == 'R' && i > j)
                ) {
                    return false
                }
            }
            ++i
            ++j
        }
        return true
    }
}
