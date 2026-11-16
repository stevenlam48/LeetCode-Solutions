package latesttimebyreplacinghiddendigits

// Time:  O(1)
// Space: O(1)

class Solution {
    fun maximumTime(time: String): String {
        val result = time.toCharArray()
        for (i in result.indices) {
            if (result[i] != '?') {
                continue
            }
            if (i == 0) {
                result[i] = if (result[1] <= '3' || result[1] == '?') '2' else '1'
            } else if (i == 1) {
                result[i] = if (result[0] == '2') '3' else '9'
            } else if (i == 3) {
                result[i] = '5'
            } else if (i == 4) {
                result[i] = '9'
            }
        }
        return String(result)
    }
}
