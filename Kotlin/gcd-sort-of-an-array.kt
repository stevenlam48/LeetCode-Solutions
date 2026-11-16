package gcdsortofanarray

// Time:  O(nlogn + n * alpha(n) + m * log(logm)) ~= O(nlogn + m), m is the max of nums
// Space: O(n + m)

class Solution {
    fun gcdSort(nums: IntArray): Boolean {
        val maxNum = nums.max()
        val uf = UnionFind(maxNum)
        modifiedSieveOfEratosthenes(maxNum, nums.toHashSet(), uf)
        val sortedNums = nums.copyOf()
        nums.sort()
        for (i in nums.indices) {
            if (uf.find(nums[i] - 1) != uf.find(sortedNums[i] - 1)) {
                return false
            }
        }
        return true
    }

    private class UnionFind(n: Int) {
        private val set = IntArray(n) { it }
        private val rank = IntArray(n)
        private var count = n

        fun find(x0: Int): Int {
            var x = x0
            if (set[x] != x) {
                set[x] = find(set[x])
            }
            return set[x]
        }

        fun union(x: Int, y: Int): Boolean {
            val xRoot = find(x)
            val yRoot = find(y)
            if (xRoot == yRoot) {
                return false
            }
            if (rank[xRoot] < rank[yRoot]) {
                set[xRoot] = yRoot
            } else if (rank[xRoot] > rank[yRoot]) {
                set[yRoot] = xRoot
            } else {
                set[yRoot] = xRoot
                ++rank[xRoot]
            }
            --count
            return true
        }

        fun size(): Int = count
    }

    private fun modifiedSieveOfEratosthenes(n: Int, lookup: Set<Int>, uf: UnionFind) {
        if (n < 2) {
            return
        }
        val isPrime = BooleanArray(n + 1) { true }
        for (i in 2 until isPrime.size) {
            if (!isPrime[i]) {
                continue
            }
            var j = i + i
            while (j < isPrime.size) {
                isPrime[j] = false
                if (j in lookup) {
                    uf.union(i - 1, j - 1)
                }
                j += i
            }
        }
    }
}
