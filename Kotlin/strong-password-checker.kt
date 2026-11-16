package strongpasswordchecker

// Time:  O(n)
// Space: O(1)

class Solution {
    fun strongPasswordChecker(s: String): Int {
        var missingTypeCount = 3
        if (s.any { it.isDigit() }) {
            --missingTypeCount
        }
        if (s.any { it.isUpperCase() }) {
            --missingTypeCount
        }
        if (s.any { it.isLowerCase() }) {
            --missingTypeCount
        }
        var totalChangeCount = 0
        var oneChangeCount = 0
        var twoChangeCount = 0
        var threeChangeCount = 0
        var i = 2
        while (i < s.length) {
            if (s[i] == s[i - 1] && s[i - 1] == s[i - 2]) {
                var length = 2
                while (i < s.length && s[i] == s[i - 1]) {
                    ++length
                    ++i
                }
                totalChangeCount += length / 3
                when (length % 3) {
                    0 -> ++oneChangeCount
                    1 -> ++twoChangeCount
                    else -> ++threeChangeCount
                }
            } else {
                ++i
            }
        }
        if (s.length < 6) {
            return maxOf(missingTypeCount, 6 - s.length)
        }
        if (s.length <= 20) {
            return maxOf(missingTypeCount, totalChangeCount)
        }
        val deleteCount = s.length - 20
        totalChangeCount -= minOf(deleteCount, oneChangeCount)
        totalChangeCount -= minOf(maxOf(deleteCount - oneChangeCount, 0), twoChangeCount * 2) / 2
        totalChangeCount -= minOf(
            maxOf(deleteCount - oneChangeCount - 2 * twoChangeCount, 0),
            threeChangeCount * 3
        ) / 3
        return deleteCount + maxOf(missingTypeCount, totalChangeCount)
    }
}
