package closestprimenumbersinrange

// Time:  precompute:  O(MAX_N * log(MAX_N))
//        runtime:     O(log(MAX_N))
// Space: O(MAX_N)


private const val MAX_N = 1_000_000

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
    return primes.toIntArray()
}

private fun compareArrays(a: IntArray, b: IntArray): Int {
    for (i in a.indices) {
        val c = a[i].compareTo(b[i])
        if (c != 0) {
            return c
        }
    }
    return 0
}

private fun combine(x: IntArray?, y: IntArray?): IntArray? {
    if (x == null || x.isEmpty()) {
        return y
    }
    if (y == null || y.isEmpty()) {
        return x
    }
    return if (compareArrays(x, y) <= 0) x else y
}

private class SegmentTree(private val n: Int) {
    private val base: Int = if (n > 1) Integer.highestOneBit(n - 1) shl 1 else 1
    private val tree: Array<IntArray?> = arrayOfNulls(if (n > 1) base shl 1 else 2)

    init {
        for (i in 0 until n) {
            tree[base + i] = intArrayOf(PRIMES[i + 1] - PRIMES[i], PRIMES[i], PRIMES[i + 1])
        }
        for (i in base - 1 downTo 1) {
            tree[i] = combine(tree[2 * i], tree[2 * i + 1])
        }
    }

    fun query(l: Int, r: Int): IntArray? {
        var left = l + base
        var right = r + base
        var accL: IntArray? = null
        var accR: IntArray? = null
        while (left <= right) {
            if (left and 1 == 1) {
                accL = combine(accL, tree[left])
                ++left
            }
            if (right and 1 == 0) {
                accR = combine(tree[right], accR)
                --right
            }
            left /= 2
            right /= 2
        }
        return combine(accL, accR)
    }
}

private val PRIMES: IntArray = linearSieveOfEratosthenes(MAX_N)
private val ST: SegmentTree = SegmentTree(PRIMES.size - 1)

private fun lowerBound(a: IntArray, v: Int): Int {
    var lo = 0
    var hi = a.size
    while (lo < hi) {
        val mid = (lo + hi) / 2
        if (a[mid] < v) lo = mid + 1 else hi = mid
    }
    return lo
}

private fun upperBound(a: IntArray, v: Int): Int {
    var lo = 0
    var hi = a.size
    while (lo < hi) {
        val mid = (lo + hi) / 2
        if (a[mid] <= v) lo = mid + 1 else hi = mid
    }
    return lo
}

class Solution {
    fun closestPrimes(left: Int, right: Int): IntArray {
        val i = lowerBound(PRIMES, left)
        val j = upperBound(PRIMES, right) - 1
        if (i > j - 1) {
            return intArrayOf(-1, -1)
        }
        val result = ST.query(i, j - 1)!!
        return intArrayOf(result[1], result[2])
    }
}
