package findthestudentthatwillreplacethechalk

// Time:  O(n)
// Space: O(1)

class Solution {
    fun chalkReplacer(chalk: IntArray, k: Int): Int {
        var sum = 0L
        for (x in chalk) {
            sum += x
        }
        var remaining = k.toLong() % sum
        var i = 0
        while (i < chalk.size) {
            if (remaining < chalk[i]) {
                return i
            }
            remaining -= chalk[i]
            ++i
        }
        return -1
    }
}
