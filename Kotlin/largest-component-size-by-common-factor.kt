package largestcomponentsizebycommonfactor

// Time:  O(f * n), f is the max number of unique prime factors
// Soace: O(p + n), p is the total number of unique primes

class Solution {
    fun largestComponentSize(A: IntArray): Int {
        val unionFind = UnionFind(A.size)
        val nodesWithCommonFactor = HashMap<Int, Int>()
        for (i in A.indices) {
            for (factor in primeFactors(A[i])) {
                if (factor !in nodesWithCommonFactor) {
                    nodesWithCommonFactor[factor] = i
                }
                unionFind.unionSet(nodesWithCommonFactor[factor]!!, i)
            }
        }
        return unionFind.maxSize()
    }

    private fun primeFactors(value: Int): List<Int> {
        var i = value
        val result = mutableListOf<Int>()
        var d = 2
        if (i % d == 0) {
            while (i % d == 0) {
                i /= d
            }
            result.add(d)
        }
        d = 3
        while (d * d <= i) {
            if (i % d == 0) {
                while (i % d == 0) {
                    i /= d
                }
                result.add(d)
            }
            d += 2
        }
        if (i != 1) {
            result.add(i)
        }
        return result
    }

    private class UnionFind(n: Int) {
        private val set = IntArray(n) { it }
        private val size = IntArray(n) { 1 }

        fun findSet(x: Int): Int {
            if (set[x] != x) {
                set[x] = findSet(set[x])
            }
            return set[x]
        }

        fun unionSet(x: Int, y: Int): Boolean {
            val xRoot = findSet(x)
            val yRoot = findSet(y)
            if (xRoot == yRoot) {
                return false
            }
            set[minOf(xRoot, yRoot)] = maxOf(xRoot, yRoot)
            size[maxOf(xRoot, yRoot)] += size[minOf(xRoot, yRoot)]
            return true
        }

        fun maxSize(): Int = size.max()
    }
}
