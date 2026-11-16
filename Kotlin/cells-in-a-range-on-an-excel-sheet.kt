package cellsinarangeonanexcelsheet

// Time:  O(26^2)
// Space: O(1)

class Solution {
    fun cellsInRange(s: String): List<String> {
        val result = mutableListOf<String>()
        for (x in s[0]..s[3]) {
            for (y in s[1]..s[4]) {
                result.add("$x$y")
            }
        }
        return result
    }
}
