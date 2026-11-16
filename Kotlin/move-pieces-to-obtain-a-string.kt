package movepiecestoobtainastring

// Time:  O(n)
// Space: O(1)

class Solution {
    fun canChange(start: String, target: String): Boolean {
        var i = 0
        var j = 0
        while (true) {
            while (i < start.length && start[i] == '_') {
                ++i
            }
            while (j < target.length && target[j] == '_') {
                ++j
            }
            if (i == start.length && j == target.length) {
                break
            }
            if (i == start.length || j == target.length || start[i] != target[j] ||
                (start[i] == 'L' && i < j) || (start[i] == 'R' && i > j)
            ) {
                return false
            }
            ++i
            ++j
        }
        return true
    }
}
