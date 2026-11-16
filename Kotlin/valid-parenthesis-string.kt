package validparenthesisstring

// Time:  O(n)
// Space: O(1)

class Solution {
    fun checkValidString(s: String): Boolean {
        var lower = 0
        var upper = 0
        for (c in s) {
            lower += if (c == '(') 1 else -1
            upper -= if (c == ')') 1 else -1
            if (upper < 0) {
                break
            }
            lower = maxOf(lower, 0)
        }
        return lower == 0
    }
}
