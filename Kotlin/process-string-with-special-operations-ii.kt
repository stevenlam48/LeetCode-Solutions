package processstringwithspecialoperationsii

// Time:  O(n)
// Space: O(1)

class Solution {
    fun processStr(s: String, k: Long): Char {
        var l = 0L
        for (x in s) {
            when (x) {
                '*' -> l = maxOf(l - 1, 0L)
                '#' -> l = l shl 1
                '%' -> continue
                else -> ++l
            }
        }
        var index = k
        if (index >= l) {
            return '.'
        }
        for (i in s.lastIndex downTo 0) {
            val x = s[i]
            when (x) {
                '*' -> ++l
                '#' -> {
                    l = l shr 1
                    if (index >= l) {
                        index -= l
                    }
                }
                '%' -> index = (l - 1) - index
                else -> {
                    if (--l == index) {
                        return x
                    }
                }
            }
        }
        return 'x'
    }
}
