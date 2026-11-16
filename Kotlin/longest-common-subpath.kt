package longestcommonsubpath

// Time:  O(m * nlogn)
// Space: O(n)

class Solution {
    fun longestCommonSubpath(n: Int, paths: Array<IntArray>): Int {
        var left = 1
        var right = paths.minOf { it.size }
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (!check(paths, mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return right
    }

    private fun check(paths: Array<IntArray>, x: Int): Boolean {
        var intersect = rabinKarp(paths[0], x)
        for (i in 1 until paths.size) {
            intersect = setIntersection(intersect, rabinKarp(paths[i], x))
            if (intersect.isEmpty()) {
                return false
            }
        }
        return true
    }

    private fun rabinKarp(arr: IntArray, x: Int): Set<List<Long>> {
        val mod = 1_000_000_007L
        val bases = longArrayOf(113, 109)
        val hashes = LongArray(bases.size)
        val powers = LongArray(bases.size) { 1 }
        for (j in bases.indices) {
            var h = 0L
            var power = 1L
            for (i in 0 until x) {
                h = (h * bases[j] + arr[i]) % mod
                power = power * bases[j] % mod
            }
            hashes[j] = h
            powers[j] = power
        }
        val lookup = hashSetOf(hashes.toList())
        for (i in x until arr.size) {
            for (j in bases.indices) {
                hashes[j] = ((hashes[j] * bases[j] - arr[i - x].toLong() * powers[j] + arr[i]) % mod + mod) % mod
            }
            lookup.add(hashes.toList())
        }
        return lookup
    }

    private fun setIntersection(a: Set<List<Long>>, b: Set<List<Long>>): Set<List<Long>> {
        if (a.size > b.size) {
            return setIntersection(b, a)
        }
        return a.filterTo(HashSet()) { it in b }
    }
}
