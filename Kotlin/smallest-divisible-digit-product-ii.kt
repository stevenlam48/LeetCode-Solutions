package smallestdivisibledigitproductii

// Time:  O(n + logt)
// Space: O(1)

class Solution {
    fun smallestNumber(num: String, t: Long): String {
        val lookup = arrayOf(
            arrayOf(intArrayOf(0, 0, 0, 0), intArrayOf(0, 1, 0, 0)),
            arrayOf(intArrayOf(1, 0, 0, 0), intArrayOf(0, 0, 0, 1)),
            arrayOf(intArrayOf(0, 0, 1, 0), intArrayOf(1, 0, 0, 1))
        )

        fun count(x0: Long): IntArray? {
            var x = x0
            val cnt = IntArray(10)
            for (i in 2..9) {
                while (x % i == 0L) {
                    x /= i
                    ++cnt[i]
                }
                if (x == 1L) {
                    return cnt
                }
            }
            return null
        }

        fun update(total: IntArray, cnt: IntArray, d: Int) {
            for (i in cnt.indices) {
                total[i] += d * cnt[i]
            }
        }

        fun diff(expect: IntArray, total: IntArray): IntArray {
            val result = IntArray(10)
            for (i in expect.indices) {
                result[i] = maxOf(expect[i] - total[i], 0)
            }
            return result
        }

        fun minFactors(cnt: IntArray): IntArray {
            val cnt8 = cnt[2] / 3
            val r2 = cnt[2] % 3
            val cnt9 = cnt[3] / 2
            val r3 = cnt[3] % 2
            val l = lookup[r2][r3]
            return intArrayOf(l[0], l[1], l[2], cnt[5], l[3], cnt[7], cnt8, cnt9)
        }

        fun format(cnt: IntArray, l: Int): String {
            val result = CharArray(l) { '1' }
            var i = l - cnt.sum()
            for (x in 2..9) {
                repeat(cnt[x - 2]) {
                    result[i++] = '0' + x
                }
            }
            return String(result)
        }

        val expect = count(t) ?: return "-1"
        val numArr = num.toCharArray()
        var i = 0
        while (i < numArr.size && numArr[i] != '0') {
            ++i
        }
        while (i < numArr.size) {
            numArr[i] = '1'
            ++i
        }
        val total = IntArray(10)
        for (c in numArr) {
            update(total, count((c - '0').toLong())!!, 1)
        }
        val d = diff(expect, total)
        if (d.all { it == 0 }) {
            return String(numArr)
        }
        for (j in numArr.size - 1 downTo 0) {
            update(total, count((numArr[j] - '0').toLong())!!, -1)
            for (x in ((numArr[j] - '0') + 1)..9) {
                update(total, count(x.toLong())!!, 1)
                val tmp = minFactors(diff(expect, total))
                update(total, count(x.toLong())!!, -1)
                if (tmp.sum() > numArr.size - 1 - j) {
                    continue
                }
                numArr[j] = '0' + x
                return String(numArr, 0, j + 1) + format(tmp, numArr.size - 1 - j)
            }
        }
        val result = minFactors(diff(expect, total))
        return format(result, maxOf(numArr.size + 1, result.sum()))
    }
}
