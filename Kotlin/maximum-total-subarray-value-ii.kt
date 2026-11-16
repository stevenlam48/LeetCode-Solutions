package maximumtotalsubarrayvalueii

// Time:  O((n + k) * logn)
// Space: O(n + k)

import java.util.PriorityQueue

class Solution {
    fun maxTotalValue(nums: IntArray, k: Int): Long {
        val idxs = nums.indices.sortedWith { a, b ->
            if (nums[a] != nums[b]) nums[a].compareTo(nums[b]) else a.compareTo(b)
        }
        fun next(left: Int, right: Int, i: Int, j: Int): Pair<Int, Int> {
            var ni = i
            var nj = j
            while (idxs[ni] !in left..right) {
                ++ni
            }
            while (idxs[nj] !in left..right) {
                --nj
            }
            return ni to nj
        }

        val lookup = hashMapOf<Pair<Int, Int>, Pair<Int, Int>>()
        lookup[0 to idxs.lastIndex] = 0 to idxs.lastIndex
        val heap = PriorityQueue<Triple<Int, Int, Int>>(
            compareByDescending<Triple<Int, Int, Int>> { it.first }
                .thenByDescending { it.second }
                .thenByDescending { it.third }
        )
        heap.add(Triple(nums[idxs.last()] - nums[idxs[0]], 0, idxs.lastIndex))
        var result = 0L
        var remaining = k
        while (remaining > 0) {
            val (value, l, r) = heap.remove()
            val (i, j) = lookup[l to r]!!
            val nl = minOf(idxs[i], idxs[j])
            val nr = maxOf(idxs[i], idxs[j])
            val count = minOf((nl - l + 1).toLong() * (r - nr + 1), remaining.toLong())
            remaining -= count.toInt()
            result += count * value
            if (nl + 1 <= r && !lookup.containsKey(nl + 1 to r)) {
                val (ni, nj) = next(nl + 1, r, i, j)
                lookup[nl + 1 to r] = ni to nj
                heap.add(Triple(nums[idxs[nj]] - nums[idxs[ni]], nl + 1, r))
            }
            if (l <= nr - 1 && !lookup.containsKey(l to nr - 1)) {
                val (ni, nj) = next(l, nr - 1, i, j)
                lookup[l to nr - 1] = ni to nj
                heap.add(Triple(nums[idxs[nj]] - nums[idxs[ni]], l, nr - 1))
            }
        }
        return result
    }
}
