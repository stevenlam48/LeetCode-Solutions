package paintingagridwiththreedifferentcolors
// Time:  O(m * 2^m + 3^m + 2^(3 * m) * logn) = O(2^(3 * m) * logn)
// Space: O(2^(2 * m))

class Solution {
    fun colorTheGrid(m: Int, n: Int): Int {
        var rows = m
        var columns = n
        if (rows > columns) {
            val temp = rows
            rows = columns
            columns = temp
        }
        var basis = 1
        repeat(rows - 1) { basis *= 3 }
        val masks = mutableListOf<Int>()
        backtracking(-1, -1, basis, masks)
        val lookup = HashMap<Int, Int>()
        for (mask in masks) {
            lookup[mask] = normalize(basis, mask)
        }
        val normalizedMaskCount = HashMap<Int, Int>()
        for (mask in masks) {
            val normalized = lookup[mask]!!
            normalizedMaskCount[normalized] = (normalizedMaskCount.getOrDefault(normalized, 0) + 1) % MOD
        }
        val adjacency = HashMap<Int, MutableList<Int>>()
        for (mask in normalizedMaskCount.keys) {
            backtracking(mask, -1, basis, adjacency.getOrPut(mask) { mutableListOf() })
        }
        val normalizedAdjacency = HashMap<Int, HashMap<Int, Int>>()
        for ((mask1, mask2s) in adjacency) {
            for (mask2 in mask2s) {
                val bucket = normalizedAdjacency.getOrPut(mask1) { HashMap() }
                val normalized = lookup[mask2]!!
                bucket[normalized] = (bucket.getOrDefault(normalized, 0) + 1) % MOD
            }
        }
        val matrix = mutableListOf<IntArray>()
        val counts = arrayOf(IntArray(normalizedMaskCount.size))
        for ((index, entry) in normalizedMaskCount.entries.withIndex()) {
            val row = IntArray(normalizedMaskCount.size)
            for ((j, mask2) in normalizedMaskCount.keys.withIndex()) {
                row[j] = normalizedAdjacency[entry.key]?.get(mask2) ?: 0
            }
            matrix.add(row)
            counts[0][index] = entry.value
        }
        val result = matrixMult(counts, matrixExpo(matrix.toTypedArray(), columns - 1))
        var answer = 0
        for (value in result[0]) {
            answer = (answer + value) % MOD
        }
        return answer
    }

    private fun backtracking(mask1: Int, mask2: Int, basis: Int, result: MutableList<Int>) {
        if (basis == 0) {
            result.add(mask2)
            return
        }
        for (i in 0 until 3) {
            if ((mask1 == -1 || mask1 / basis % 3 != i) &&
                (mask2 == -1 || mask2 / (basis * 3) % 3 != i)
            ) {
                backtracking(mask1, if (mask2 != -1) mask2 + i * basis else i * basis, basis / 3, result)
            }
        }
    }

    private fun matrixExpo(a: Array<IntArray>, exponent: Int): Array<IntArray> {
        var result = Array(a.size) { IntArray(a.size) }
        var aExp = a.map { it.copyOf() }.toTypedArray()
        for (i in a.indices) {
            result[i][i] = 1
        }
        var power = exponent
        while (power != 0) {
            if (power % 2 == 1) {
                result = matrixMult(result, aExp)
            }
            aExp = matrixMult(aExp, aExp)
            power /= 2
        }
        return result
    }

    private fun matrixMult(a: Array<IntArray>, b: Array<IntArray>): Array<IntArray> {
        val result = Array(a.size) { IntArray(b[0].size) }
        for (i in a.indices) {
            for (j in b[0].indices) {
                var entry = 0L
                for (k in b.indices) {
                    entry = (a[i][k].toLong() * b[k][j] % MOD + entry) % MOD
                }
                result[i][j] = entry.toInt()
            }
        }
        return result
    }

    private fun normalize(basis: Int, mask: Int): Int {
        val norm = HashMap<Int, Int>()
        var result = 0
        var b = basis
        while (b != 0) {
            val x = mask / b % 3
            if (!norm.containsKey(x)) {
                norm[x] = norm.size
            }
            result += norm[x]!! * b
            b /= 3
        }
        return result
    }

    private companion object {
        const val MOD = 1_000_000_007
    }
}
