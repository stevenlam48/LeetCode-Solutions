package minimumstabilityfactorofarray

// Time:  O(nlogn * logr)
// Space: O(nlogn)

class Solution {
    fun minStable(nums: IntArray, maxC: Int): Int {
        fun binarySearchRight(initialLeft: Int, initialRight: Int, check: (Int) -> Boolean): Int {
            var left = initialLeft
            var right = initialRight
            while (left <= right) {
                val mid = left + (right - left) / 2
                if (!check(mid)) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            }
            return right
        }

        val rmq = SparseTable(nums) { a, b -> gcd(a, b) }
        fun check(l: Int): Boolean {
            var cnt = 0
            var i = 0
            while (i + l - 1 < nums.size) {
                if (rmq.query(i, i + l - 1) >= 2) {
                    ++cnt
                    i += l
                } else {
                    ++i
                }
            }
            return cnt > maxC
        }

        return binarySearchRight(1, nums.size) { l -> check(l) }
    }

    private fun gcd(a: Long, b: Long): Long {
        return if (b == 0L) a else gcd(b, a % b)
    }

    private class SparseTable(arr: IntArray, private val fn: (Long, Long) -> Long) {
        private val st: Array<LongArray>

        init {
            val n = arr.size
            val k = 31 - Integer.numberOfLeadingZeros(n)
            st = Array(k + 1) { LongArray(n) }
            for (j in arr.indices) {
                st[0][j] = arr[j].toLong()
            }
            for (i in 1..k) {
                var j = 0
                while (j + (1 shl i) <= n) {
                    st[i][j] = fn(st[i - 1][j], st[i - 1][j + (1 shl (i - 1))])
                    ++j
                }
            }
        }

        fun query(l: Int, r: Int): Long {
            val i = 31 - Integer.numberOfLeadingZeros(r - l + 1)
            return fn(st[i][l], st[i][r - (1 shl i) + 1])
        }
    }
}
