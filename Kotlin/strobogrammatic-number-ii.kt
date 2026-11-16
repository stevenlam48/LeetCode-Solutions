package strobogrammaticnumberii
// Time:  O(n * 5^(n/2))
// Space: O(n)

class Solution {
    fun findStrobogrammatic(n: Int): List<String> {
        var result = listOf("")
        if (n % 2 != 0) {
            result = listOf("0", "1", "8")
        }
        var i = n % 2
        while (i < n) {
            val newResult = mutableListOf<String>()
            for (num in result) {
                for ((a, b) in lookup) {
                    if (i != n - 2 || a != '0') {
                        newResult.add(a + num + b)
                    }
                }
            }
            result = newResult
            i += 2
        }
        return result
    }

    private val lookup = listOf('0' to '0', '1' to '1', '6' to '9', '8' to '8', '9' to '6')
}
