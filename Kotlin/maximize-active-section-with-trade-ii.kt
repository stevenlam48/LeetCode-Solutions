package maximizeactivesectionwithtradeii

// Time:  O(nlogn + q)
// Space: O(nlogn)

// sparse table
class Solution {
    fun maxActiveSectionsAfterTrade(s: String, queries: Array<IntArray>): IntArray {
        var cnt1 = 0
        val idxs = ArrayList<IntArray>()
        val lookup = IntArray(s.length)
        for (i in s.indices) {
            if (s[i] == '0') {
                if (i - 1 >= 0 && s[i - 1] == '0') {
                    ++idxs[idxs.size - 1][1]
                } else {
                    idxs.add(intArrayOf(i, 1))
                }
            } else {
                ++cnt1
            }
            lookup[i] = idxs.size - 1
        }
        if (idxs.isEmpty()) {
            return IntArray(queries.size) { cnt1 }
        }
        val arr = IntArray(idxs.size - 1)
        for (i in 0 until idxs.size - 1) {
            arr[i] = idxs[i][1] + idxs[i + 1][1]
        }
        val st = SparseTable(arr) { a, b -> maxOf(a, b) }
        val result = IntArray(queries.size) { cnt1 }
        for (i in queries.indices) {
            val l = queries[i][0]
            val r = queries[i][1]
            val left = lookup[l] + 1
            val right = lookup[r] - (if (s[r] == '0') 1 else 0)
            val leftCnt = if (lookup[l] != -1) idxs[lookup[l]][1] - (l - idxs[lookup[l]][0]) else -1
            val rightCnt = if (lookup[r] != -1) r - idxs[lookup[r]][0] + 1 else -1
            if (left <= right - 1) {
                result[i] = maxOf(result[i], cnt1 + st.query(left, right - 1))
            }
            if (s[l] == '0' && s[r] == '0' && lookup[l] + 1 == lookup[r]) {
                result[i] = maxOf(result[i], cnt1 + leftCnt + rightCnt)
            }
            if (s[l] == '0' && lookup[l] + 1 <= right) {
                result[i] = maxOf(result[i], cnt1 + leftCnt + idxs[lookup[l] + 1][1])
            }
            if (s[r] == '0' && left <= lookup[r] - 1) {
                result[i] = maxOf(result[i], cnt1 + rightCnt + idxs[lookup[r] - 1][1])
            }
        }
        return result
    }

    private class SparseTable(private val arr: IntArray, private val fn: (Int, Int) -> Int) {
        private val st: Array<IntArray>
        private val bitLength: IntArray

        init {
            val n = arr.size
            val k = if (n > 0) 31 - Integer.numberOfLeadingZeros(n) else 0
            val bl = ArrayList<Int>()
            bl.add(0)
            for (i in 0..k) {
                val cnt = minOf(1 shl i, (n + 1) - bl.size)
                for (x in 0 until cnt) {
                    bl.add(i + 1)
                }
            }
            bitLength = bl.toIntArray()
            st = Array(k + 1) { IntArray(n) }
            for (j in 0 until n) {
                st[0][j] = arr[j]
            }
            for (i in 1..k) {
                for (j in 0..n - (1 shl i)) {
                    st[i][j] = fn(st[i - 1][j], st[i - 1][j + (1 shl (i - 1))])
                }
            }
        }

        fun query(L: Int, R: Int): Int {
            val i = bitLength[R - L + 1] - 1
            return fn(st[i][L], st[i][R - (1 shl i) + 1])
        }
    }
}
