package maximumvalueofastringinanarray

// Time:  O(n * l)
// Space: O(1)

class Solution {
    fun maximumValue(strs: List<String>): Int {
        var result = 0
        for (s in strs) {
            result = maxOf(result, if (s.all { it in '0'..'9' }) s.toInt() else s.length)
        }
        return result
    }
}
