package passwordstrength

// Time:  O(n)
// Space: O(1)

class Solution {
    fun passwordStrength(password: String): Int {
        var result = 0
        for (x in password.toHashSet()) {
            result += when {
                x.isLowerCase() -> 1
                x.isUpperCase() -> 2
                x.isDigit() -> 3
                else -> 5
            }
        }
        return result
    }
}
