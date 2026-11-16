package timeneededtorearrangeabinarystring
// Time:  O(n)
// Space: O(1)

class Solution {
    fun secondsToRemoveOccurrences(s: String): Int {
        var result = 0
        var count = 0
        for (c in s) {
            if (c == '0') {
                ++count
                continue
            }
            if (count != 0) {
                result = maxOf(result + 1, count)
            }
        }
        return result
    }
}
