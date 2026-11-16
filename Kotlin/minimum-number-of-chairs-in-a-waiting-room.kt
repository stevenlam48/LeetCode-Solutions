package minimumnumberofchairsinawaitingroom
// Time:  O(n)
// Space: O(1)

class Solution {
    fun minimumChairs(s: String): Int {
        var result = 0
        var curr = 0
        for (x in s) {
            curr += if (x == 'E') 1 else -1
            result = maxOf(result, curr)
        }
        return result
    }
}
