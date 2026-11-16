package strongpasswordcheckerii
// Time:  O(n)
// Space: O(1)

class Solution {
    fun strongPasswordCheckerII(password: String): Boolean {
        return password.length >= 8 &&
            password.any { it.isLowerCase() } &&
            password.any { it.isUpperCase() } &&
            password.any { it.isDigit() } &&
            password.any { it in SPECIAL } &&
            password.zipWithNext().all { (a, b) -> a != b }
    }

    private companion object {
        val SPECIAL = setOf('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+')
    }
}
