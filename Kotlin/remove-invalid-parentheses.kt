package removeinvalidparentheses

// Time:  O(C(n, c)), try out all possible substrings with the minimum c deletion.
// Space: O(c), the depth is at most c, and it costs n at each depth
class Solution {
    fun removeInvalidParentheses(s: String): List<String> {
        var leftRemoved = 0
        var rightRemoved = 0
        for (c in s) {
            if (c == '(') {
                ++leftRemoved
            } else if (c == ')') {
                if (leftRemoved == 0) {
                    ++rightRemoved
                } else {
                    --leftRemoved
                }
            }
        }

        val res = ArrayList<String>()
        val removed = ArrayList<Int>()
        helper(s, 0, leftRemoved, rightRemoved, removed, res)
        return res
    }

    private fun helper(
        s: String,
        start: Int,
        leftRemoved: Int,
        rightRemoved: Int,
        removed: ArrayList<Int>,
        res: ArrayList<String>
    ) {
        if (leftRemoved == 0 && rightRemoved == 0) {
            val tmp = StringBuilder()
            var j = 0
            for (i in s.indices) {
                if (j < removed.size && i == removed[j]) {
                    ++j
                } else {
                    tmp.append(s[i])
                }
            }
            if (isValid(tmp.toString())) {
                res.add(tmp.toString())
            }
            return
        }

        for (i in start until s.length) {
            if (rightRemoved == 0 && leftRemoved > 0 && s[i] == '(') {
                if (i == start || s[i] != s[i - 1]) { // Skip duplicated.
                    removed.add(i)
                    helper(s, i + 1, leftRemoved - 1, rightRemoved, removed, res)
                    removed.removeAt(removed.size - 1)
                }
            } else if (rightRemoved > 0 && s[i] == ')') {
                if (i == start || s[i] != s[i - 1]) { // Skip duplicated.
                    removed.add(i)
                    helper(s, i + 1, leftRemoved, rightRemoved - 1, removed, res)
                    removed.removeAt(removed.size - 1)
                }
            }
        }
    }

    private fun isValid(s: String): Boolean {
        var sum = 0
        for (c in s) {
            if (c == '(') {
                ++sum
            } else if (c == ')') {
                --sum
            }
            if (sum < 0) {
                return false
            }
        }
        return sum == 0
    }
}
