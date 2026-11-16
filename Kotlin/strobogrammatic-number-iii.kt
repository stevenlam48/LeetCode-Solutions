package strobogrammaticnumberiii
// Time:  O(5^(n/2))
// Space: O(n)

class Solution {
    fun strobogrammaticInRange(low: String, high: String): Int {
        val count = countStrobogrammaticUntil(high, false) -
            countStrobogrammaticUntil(low, false) + if (isStrobogrammatic(low)) 1 else 0
        return if (count >= 0) count else 0
    }

    private fun countStrobogrammaticUntil(num: String, canStartWithZero: Boolean): Int {
        if (canStartWithZero && num in cache) {
            return cache[num]!!
        }
        var count = 0
        if (num.length == 1) {
            for (c in charArrayOf('0', '1', '8')) {
                if (num[0] >= c) {
                    ++count
                }
            }
            cache[num] = count
            return count
        }
        for ((first, second) in lookup) {
            if (canStartWithZero || first != '0') {
                if (num[0] > first) {
                    if (num.length == 2) {
                        ++count
                    } else {
                        count += countStrobogrammaticUntil("9".repeat(num.length - 2), true)
                    }
                } else if (num[0] == first) {
                    if (num.length == 2) {
                        count += if (num[num.length - 1] >= second) 1 else 0
                    } else {
                        if (num[num.length - 1] >= second) {
                            count += countStrobogrammaticUntil(getMid(num), true)
                        } else if (getMid(num) != "0".repeat(num.length - 2)) {
                            count += countStrobogrammaticUntil(getMid(num), true) -
                                if (isStrobogrammatic(getMid(num))) 1 else 0
                        }
                    }
                }
            }
        }
        if (!canStartWithZero) {
            for (i in num.length - 1 downTo 1) {
                count += countStrobogrammaticByLength(i)
            }
        } else {
            cache[num] = count
        }
        return count
    }

    private fun getMid(num: String): String = num.substring(1, num.length - 1)

    private fun countStrobogrammaticByLength(n: Int): Int = when (n) {
        1 -> 3
        2 -> 4
        3 -> 4 * 3
        else -> 5 * countStrobogrammaticByLength(n - 2)
    }

    private fun isStrobogrammatic(num: String): Boolean {
        for (i in 0 until (num.length + 1) / 2) {
            val rotated = lookupMap[num[num.length - 1 - i]] ?: return false
            if (num[i] != rotated) {
                return false
            }
        }
        return true
    }

    private val lookup = listOf('0' to '0', '1' to '1', '6' to '9', '8' to '8', '9' to '6')
    private val lookupMap = lookup.toMap()
    private val cache = HashMap<String, Int>()
}
