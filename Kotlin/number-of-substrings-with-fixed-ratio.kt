package numberofsubstringswithfixedratio
// Time:  O(n)
// Space: O(n)

class Solution {
    fun fixedRatio(s: String, num1: Int, num2: Int): Long {
        val lookup = HashMap<Long, Int>()
        lookup[0] = 1
        var result = 0L
        var current = 0L
        for (character in s) {
            current += if (character == '0') -num2 else num1
            result += lookup.getOrDefault(current, 0)
            lookup[current] = lookup.getOrDefault(current, 0) + 1
        }
        return result
    }
}
