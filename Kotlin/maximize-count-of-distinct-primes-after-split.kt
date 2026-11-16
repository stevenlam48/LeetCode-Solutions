package maximizecountofdistinctprimesaftersplit

import java.util.TreeSet

// Time:  O(r + nlogn + qlogn), r = max(nums)
// Space: O(r + n)

// number theory, bst, segment tree
private const val MAX_N = 100000

private fun linearSieveOfEratosthenes(n: Int): IntArray {
    val spf = IntArray(n + 1) { -1 }
    val primes = ArrayList<Int>()
    for (i in 2..n) {
        if (spf[i] == -1) {
            spf[i] = i
            primes.add(i)
        }
        for (p in primes) {
            if (i * p > n || p > spf[i]) {
                break
            }
            spf[i * p] = p
        }
    }
    return spf
}

private val SPF = linearSieveOfEratosthenes(MAX_N)

class Solution {
    fun maximumCount(nums: IntArray, queries: Array<IntArray>): IntArray {
        val lookup = HashMap<Int, TreeSet<Int>>()
        val st = SegmentTree(nums.size - 1)

        fun add(i: Int, d: Int) {
            val x = nums[i]
            if (SPF[x] != x) {
                return
            }
            val set = lookup.getOrPut(x) { TreeSet() }
            if (d == 1) {
                set.add(i)
            }
            if (set.size == 1) {
                st.update(0, nums.size - 2, d)
            } else if (i == set.first()) {
                st.update(i, set.higher(i)!! - 1, d)
            } else if (i == set.last()) {
                st.update(set.lower(i)!!, i - 1, d)
            }
            if (d == -1) {
                set.remove(i)
            }
        }

        for (i in nums.indices) {
            add(i, 1)
        }
        val result = IntArray(queries.size)
        for (i in queries.indices) {
            val idx = queries[i][0]
            val x = queries[i][1]
            if (nums[idx] != x) {
                add(idx, -1)
                nums[idx] = x
                add(idx, 1)
            }
            result[i] = st.tree[1]
        }
        return result
    }

    private class SegmentTree(N: Int) {
        val tree: IntArray
        private val base: Int
        private val lazy: IntArray

        init {
            base = if (N > 1) 1 shl (31 - Integer.numberOfLeadingZeros(N - 1) + 1) else 1
            lazy = IntArray(base)
            tree = IntArray(if (N > 1) 1 shl (31 - Integer.numberOfLeadingZeros(N - 1) + 2) else 2)
        }

        fun update(L: Int, R: Int, value: Int) {
            var l = L + base
            var r = R + base
            val l0 = l
            val r0 = r
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
            pull(l0)
            pull(r0)
        }

        fun query(L: Int, R: Int): Int {
            if (L > R) {
                return 0
            }
            var l = L + base
            var r = R + base
            push(l)
            push(r)
            var left = 0
            var right = 0
            while (l <= r) {
                if ((l and 1) == 1) {
                    left = maxOf(left, tree[l])
                    ++l
                }
                if ((r and 1) == 0) {
                    right = maxOf(tree[r], right)
                    --r
                }
                l = l shr 1
                r = r shr 1
            }
            return maxOf(left, right)
        }

        private fun apply(x: Int, value: Int) {
            tree[x] += value
            if (x < base) {
                lazy[x] += value
            }
        }

        private fun pull(x0: Int) {
            var x = x0
            while (x > 1) {
                x = x shr 1
                tree[x] = maxOf(tree[x shl 1], tree[(x shl 1) + 1])
                if (lazy[x] != 0) {
                    tree[x] += lazy[x]
                }
            }
        }

        private fun push(x: Int) {
            var h = 31 - Integer.numberOfLeadingZeros(x) - 1
            while (h > 0) {
                val y = x shr h
                if (lazy[y] != 0) {
                    apply(y shl 1, lazy[y])
                    apply((y shl 1) + 1, lazy[y])
                    lazy[y] = 0
                }
                --h
            }
        }
    }
}
