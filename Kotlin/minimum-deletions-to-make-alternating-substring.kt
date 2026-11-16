package minimumdeletionstomakealternatingsubstring

// Time:  O((n + q) * logn)
// Space: O(n)

class BIT(n: Int) {
    private val bit = IntArray(n + 1)

    fun add(i0: Int, value: Int) {
        var i = i0 + 1
        while (i < bit.size) {
            bit[i] += value
            i += lowerBit(i)
        }
    }

    fun query(i0: Int): Int {
        var i = i0 + 1
        var total = 0
        while (i > 0) {
            total += bit[i]
            i -= lowerBit(i)
        }
        return total
    }

    private fun lowerBit(i: Int): Int {
        return i and -i
    }
}

class Solution {
    fun minDeletions(s: String, queries: Array<IntArray>): IntArray {
        val chars = s.toCharArray()
        val bit = BIT(chars.size - 1)
        for (i in 0 until chars.size - 1) {
            if (chars[i] == chars[i + 1]) {
                bit.add(i, 1)
            }
        }
        val result = mutableListOf<Int>()
        for (q in queries) {
            if (q.size == 3) {
                result.add(bit.query(q[2] - 1) - bit.query(q[1] - 1))
                continue
            }
            val i = q[1]
            chars[i] = if (chars[i] == 'A') 'B' else 'A'
            if (i - 1 >= 0) {
                bit.add(i - 1, if (chars[i - 1] == chars[i]) 1 else -1)
            }
            if (i + 1 < chars.size) {
                bit.add(i, if (chars[i] == chars[i + 1]) 1 else -1)
            }
        }
        return result.toIntArray()
    }
}
