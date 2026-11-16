package checkifnumbersareascendinginasentence

// Time:  O(n)
// Space: O(1)
class Solution {
    fun areNumbersAscending(s: String): Boolean {
        var prev = -1
        var curr = -1
        for (c in s) {
            if (c in '0'..'9') {
                curr = maxOf(curr, 0) * 10 + (c - '0')
                continue
            }
            if (prev != -1 && curr != -1 && prev >= curr) {
                return false
            }
            if (curr != -1) {
                prev = curr
            }
            curr = -1
        }
        return curr == -1 || prev < curr
    }
}
