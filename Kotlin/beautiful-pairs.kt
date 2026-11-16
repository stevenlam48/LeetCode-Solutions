package beautifulpairs

// Time:  O(n) on average
// Space: O(n)

import kotlin.math.abs
import kotlin.math.floor

class Solution {
    fun beautifulPair(nums1: IntArray, nums2: IntArray): IntArray {
        val points = ArrayList<IntArray>(nums1.size)
        for (i in nums1.indices) {
            points.add(intArrayOf(nums1[i], nums2[i], i))
        }
        var result = IntArray(3) { Int.MAX_VALUE }
        val duplicates = HashMap<List<Int>, Int>()
        for (i in points.indices.reversed()) {
            val key = listOf(points[i][0], points[i][1])
            val previous = duplicates[key]
            if (previous != null) {
                val candidate = intArrayOf(0, i, previous)
                if (compare(candidate, result) < 0) {
                    result = candidate
                }
            }
            duplicates[key] = i
        }
        if (result[0] == 0) {
            return intArrayOf(result[1], result[2])
        }
        val order = points.indices.sortedWith(Comparator { a, b -> compare(points[a], points[b]) })
        fun dist(firstPoint: IntArray, secondPoint: IntArray): IntArray {
            var a = firstPoint
            var b = secondPoint
            if (a[2] > b[2]) {
                val temp = a
                a = b
                b = temp
            }
            return intArrayOf(abs(a[0] - b[0]) + abs(a[1] - b[1]), a[2], b[2])
        }
        fun improve(): Boolean {
            val lookup = HashMap<List<Int>, IntArray>()
            for (p in points) {
                val size = result[0] / 2.0
                val i = floor(p[0] / size).toInt()
                val j = floor(p[1] / size).toInt()
                for (ni in i - 2..i + 2) {
                    for (nj in j - 2..j + 2) {
                        val other = lookup[listOf(ni, nj)] ?: continue
                        val d = dist(p, other)
                        if (compare(d, result) < 0) {
                            result = d
                            return true
                        }
                    }
                }
                lookup[listOf(i, j)] = p
            }
            return false
        }
        points.shuffle()
        result = dist(points[0], points[1])
        while (improve()) {
        }
        return intArrayOf(result[1], result[2])
    }

    private fun compare(a: IntArray, b: IntArray): Int {
        for (i in 0 until minOf(a.size, b.size)) {
            if (a[i] != b[i]) {
                return a[i].compareTo(b[i])
            }
        }
        return a.size.compareTo(b.size)
    }
}
