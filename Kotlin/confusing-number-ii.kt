package confusingnumberii
// Time:  O(logn)
// Space: O(logn)

class Solution {
    fun confusingNumberII(n: Int): Int {
        return totalCount(n) - validCountInLessLength(n) - validCountInFullLength(n)
    }

    private fun totalCount(n: Int): Int {
        val s = n.toString()
        var total = 0
        var p = intPow(lookup.size, s.length - 1)
        for (i in 0..s.length) {
            if (i == s.length) {
                ++total
                break
            }
            var smaller = 0
            for (key in lookup.keys) {
                smaller += if (key < s[i]) 1 else 0
            }
            total += smaller * p
            if (s[i] !in lookup) {
                break
            }
            p /= lookup.size
        }
        return total - 1
    }

    private fun validCountInLessLength(n: Int): Int {
        val s = n.toString()
        var valid = 0
        var total = centers.size
        var i = 1
        while (i < s.length) {
            if (i == 1) {
                valid += centers.keys.count { it != '0' }
            } else {
                valid += total * (lookup.size - 1)
                total *= lookup.size
            }
            i += 2
        }
        total = 1
        i = 2
        while (i < s.length) {
            valid += total * (lookup.size - 1)
            total *= lookup.size
            i += 2
        }
        return valid
    }

    private fun validCountInFullLength(n: Int): Int {
        val s = n.toString()
        val halfS = s.substring(0, (s.length + 1) / 2)
        var total = 0
        val choices = if (s.length % 2 == 1) centers else lookup
        var p = intPow(lookup.size, halfS.length - 2) * choices.size
        for (i in halfS.indices) {
            if (i == halfS.length - 1) {
                for (key in choices.keys) {
                    if (key == '0' && i == 0) {
                        continue
                    }
                    total += if (key < halfS[i]) 1 else 0
                }
                if (halfS[i] !in choices) {
                    break
                }
                val tmp = StringBuilder(halfS)
                var j = halfS.length - 1 - s.length % 2
                while (j >= 0) {
                    tmp.append(lookup.getValue(halfS[j]))
                    --j
                }
                if (tmp.toString().toLong() <= n && n != 0) {
                    ++total
                }
                break
            }
            var smaller = 0
            for (key in lookup.keys) {
                if (key == '0' && i == 0) {
                    continue
                }
                smaller += if (key < halfS[i]) 1 else 0
            }
            total += smaller * p
            if (halfS[i] !in lookup) {
                break
            }
            p /= lookup.size
        }
        return total
    }

    private fun intPow(base: Int, exponent: Int): Int {
        if (exponent < 0) {
            return 0
        }
        var result = 1
        repeat(exponent) {
            result *= base
        }
        return result
    }

    private val lookup = mapOf('0' to '0', '1' to '1', '6' to '9', '8' to '8', '9' to '6')
    private val centers = mapOf('0' to '0', '1' to '1', '8' to '8')
}
