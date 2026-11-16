package maximumnumberofnonoverlappingsubstrings
// Time:  O(n)
// space: O(1)

class Solution {
    fun maxNumOfSubstrings(s: String): List<String> {
        val first = IntArray(26) { Int.MAX_VALUE }
        val last = IntArray(26) { Int.MIN_VALUE }
        for (i in s.indices) {
            first[s[i] - 'a'] = minOf(first[s[i] - 'a'], i)
            last[s[i] - 'a'] = maxOf(last[s[i] - 'a'], i)
        }
        val result = mutableListOf("")
        var right = Int.MAX_VALUE
        for (left in s.indices) {
            if (left != first[s[left] - 'a']) {
                continue
            }
            val newRight = findRightFromLeft(s, first, last, left)
            if (newRight == -1) {
                continue
            }
            if (left > right) {
                result.add("")
            }
            right = newRight
            result[result.lastIndex] = s.substring(left, right + 1)
        }
        return result
    }

    private fun findRightFromLeft(s: String, first: IntArray, last: IntArray, left: Int): Int {
        var right = last[s[left] - 'a']
        for (i in left..right) {
            if (first[s[i] - 'a'] < left) {
                return -1
            }
            right = maxOf(right, last[s[i] - 'a'])
        }
        return right
    }
}
