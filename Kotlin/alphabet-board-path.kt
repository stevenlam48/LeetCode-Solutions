package alphabetboardpath

// Time:  O(n)
// Space: O(1)

class Solution {
    fun alphabetBoardPath(target: String): String {
        val result = StringBuilder()
        var x = 0
        var y = 0
        for (c in target) {
            val x1 = (c - 'a') % 5
            val y1 = (c - 'a') / 5
            repeat(maxOf(y - y1, 0)) { result.append('U') }
            repeat(maxOf(x - x1, 0)) { result.append('L') }
            repeat(maxOf(x1 - x, 0)) { result.append('R') }
            repeat(maxOf(y1 - y, 0)) { result.append('D') }
            result.append('!')
            x = x1
            y = y1
        }
        return result.toString()
    }
}
