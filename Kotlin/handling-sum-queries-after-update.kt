package handlingsumqueriesafterupdate

// Time:  O(nlogn + m + qlogn)
// Space: O(n)

// segment tree
class Solution {
    fun handleQuery(nums1: IntArray, nums2: IntArray, queries: Array<IntArray>): List<Long> {
        val st = SegmentTree(nums1)
        val result = ArrayList<Long>()
        var total = 0L
        for (x in nums2) {
            total += x
        }
        for (q in queries) {
            if (q[0] == 1) {
                st.update(q[1], q[2], intArrayOf(1, 0))
            } else if (q[0] == 2) {
                total += st.query(0, nums1.size - 1)[0].toLong() * q[1]
            } else if (q[0] == 3) {
                result.add(total)
            }
        }
        return result
    }

    private class SegmentTree(nums: IntArray) {
        private val base = nums.size
        private val tree: Array<IntArray?>
        private val lazy: Array<IntArray?>
        private var height = 1

        init {
            tree = arrayOfNulls(2 * base)
            lazy = arrayOfNulls(2 * base)
            while ((1 shl height) < base) {
                ++height
            }
            for (i in base until base + nums.size) {
                tree[i] = intArrayOf(nums[i - base], nums[i - base] xor 1)
            }
            for (i in base - 1 downTo 1) {
                tree[i] = queryFn(tree[2 * i], tree[2 * i + 1])
            }
        }

        fun update(l0: Int, r0: Int, value: IntArray) {
            var l = l0 + base
            var r = r0 + base
            val l0base = l
            val r0base = r
            while (l <= r) {
                if ((l and 1) == 1) {
                    apply(l, value)
                    ++l
                }
                if ((r and 1) == 0) {
                    apply(r, value)
                    --r
                }
                l = l shr 1
                r = r shr 1
            }
            pull(l0base)
            pull(r0base)
        }

        fun query(l0: Int, r0: Int): IntArray {
            var result: IntArray? = null
            if (l0 > r0) {
                return IntArray(0)
            }
            var l = l0 + base
            var r = r0 + base
            push(l)
            push(r)
            while (l <= r) {
                if ((l and 1) == 1) {
                    result = queryFn(result, tree[l])
                    ++l
                }
                if ((r and 1) == 0) {
                    result = queryFn(result, tree[r])
                    --r
                }
                l = l shr 1
                r = r shr 1
            }
            return result ?: IntArray(0)
        }

        private fun apply(x: Int, value: IntArray) {
            tree[x] = updateFn(tree[x], value)
            if (x < base) {
                lazy[x] = updateFn(lazy[x], value)
            }
        }

        private fun pull(x0: Int) {
            var x = x0
            while (x > 1) {
                x = x shr 1
                tree[x] = queryFn(tree[x * 2], tree[x * 2 + 1])
                if (lazy[x] != null) {
                    tree[x] = updateFn(tree[x], lazy[x])
                }
            }
        }

        private fun push(x0: Int) {
            for (h in height downTo 1) {
                val y = x0 shr h
                val pending = lazy[y]
                if (pending != null) {
                    apply(y * 2, pending)
                    apply(y * 2 + 1, pending)
                    lazy[y] = null
                }
            }
        }

        private fun queryFn(x: IntArray?, y: IntArray?): IntArray? {
            if (x == null) {
                return y
            }
            if (y == null) {
                return x
            }
            return intArrayOf(x[0] + y[0], x[1] + y[1])
        }

        private fun updateFn(x: IntArray?, y: IntArray?): IntArray? {
            if (x == null) {
                return y
            }
            if (y == null) {
                return x
            }
            return if (y[0] == 1 && y[1] == 0) intArrayOf(x[1], x[0]) else intArrayOf(x[0], x[1])
        }
    }
}
