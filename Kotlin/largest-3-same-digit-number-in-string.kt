package largest3samedigitnumberinstring

// Time:  O(n)
// Space: O(1)

class Solution {
    fun largestGoodInteger(num: String): String {
        var result = 0.toChar()
        var cnt = 0
        for (i in num.indices) {
            ++cnt
            if (i + 1 < num.length && num[i] == num[i + 1]) {
                continue
            }
            if (cnt >= 3) {
                result = maxOf(result, num[i])
            }
            cnt = 0
        }
        return if (result != 0.toChar()) result.toString().repeat(3) else ""
    }
}
