package lexicographicallysmalleststringaftersubstringoperation

// Time:  O(n)
// Space: O(1)

class Solution {
    fun smallestString(s: String): String {
        val result = s.toCharArray()
        var i = 0
        while (i < result.size && result[i] == 'a') {
            ++i
        }
        if (i == result.size) {
            result[result.lastIndex] = 'z'
        } else {
            while (i < result.size && result[i] != 'a') {
                --result[i]
                ++i
            }
        }
        return String(result)
    }
}
