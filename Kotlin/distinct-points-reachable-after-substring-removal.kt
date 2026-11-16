package distinctpointsreachableaftersubstringremoval
// Time:  O(n)
// Space: O(n)

class Solution {
    fun distinctPoints(s: String, k: Int): Int {
        val directions = mapOf('U' to (0 to 1), 'D' to (0 to -1), 'L' to (-1 to 0), 'R' to (1 to 0))
        var x = 0
        var y = 0
        val lookup = mutableSetOf(x to y)
        for (i in k until s.length) {
            x += directions.getValue(s[i]).first - directions.getValue(s[i - k]).first
            y += directions.getValue(s[i]).second - directions.getValue(s[i - k]).second
            lookup.add(x to y)
        }
        return lookup.size
    }
}
