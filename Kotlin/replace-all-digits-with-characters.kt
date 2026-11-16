package replacealldigitswithcharacters
// Time:  O(n)
// Space: O(1)

class Solution {
    fun replaceDigits(s: String): String {
        val result = s.toCharArray()
        for (i in 1 until result.size step 2) {
            result[i] = result[i] + (result[i - 1].code - '0'.code)
        }
        return String(result)
    }
}
