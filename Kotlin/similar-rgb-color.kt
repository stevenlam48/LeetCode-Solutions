package similarrgbcolor

// Time:  O(1)
// Space: O(1)
class Solution {
    fun similarRGB(color: String): String {
        var result = "#"
        result += round(color.substring(1, 3))
        result += round(color.substring(3, 5))
        result += round(color.substring(5, 7))
        return result
    }

    private fun round(color: String): String {
        val decimal = color.toInt(16)
        val q = decimal / 17 + if (decimal % 17 > 8) 1 else 0
        return (17 * q).toString(16).padStart(2, '0')
    }
}
