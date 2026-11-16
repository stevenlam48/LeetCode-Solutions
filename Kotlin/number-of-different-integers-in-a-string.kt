package numberofdifferentintegersinastring

// Time:  O(n)
// Space: O(n)

class Solution {
    fun numDifferentIntegers(word: String): Int {
        val result = HashSet<String>()
        val num = StringBuilder()
        for (c in word + ' ') {
            if (c in '0'..'9') {
                if (num.isNotEmpty() && num[0] == '0') {
                    num[0] = c
                } else {
                    num.append(c)
                }
            } else if (num.isNotEmpty()) {
                result.add(num.toString())
                num.setLength(0)
            }
        }
        return result.size
    }
}
