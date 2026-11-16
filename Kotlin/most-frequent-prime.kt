package mostfrequentprime
// Time:  precompute: O(10^MAX_N_M)
//        runtime:    O(n * m * (n + m))
// Space: O(10^MAX_N_M + n * m * (n + m))

private fun linearSieveOfEratosthenes(n: Int): IntArray {
    val spf = IntArray(n + 1) { -1 }
    val primes = mutableListOf<Int>()
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

private const val MAX_N_M = 6
private val SPF = linearSieveOfEratosthenes(999999)
private val DIRECTIONS = arrayOf(
    intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(0, -1),
    intArrayOf(1, 1), intArrayOf(1, -1), intArrayOf(-1, 1), intArrayOf(-1, -1)
)

class Solution {
    fun mostFrequentPrime(mat: Array<IntArray>): Int {
        fun numbers(startI: Int, startJ: Int, di: Int, dj: Int): List<Int> {
            val result = mutableListOf<Int>()
            var i = startI
            var j = startJ
            var curr = 0
            while (i >= 0 && i < mat.size && j >= 0 && j < mat[0].size) {
                curr = curr * 10 + mat[i][j]
                result.add(curr)
                i += di
                j += dj
            }
            return result
        }

        val cnt = HashMap<Int, Int>()
        for (i in mat.indices) {
            for (j in mat[0].indices) {
                for ((di, dj) in DIRECTIONS) {
                    for (x in numbers(i, j, di, dj)) {
                        if (x > 10 && SPF[x] == x) {
                            cnt[x] = cnt.getOrDefault(x, 0) + 1
                        }
                    }
                }
            }
        }
        var maxCount = 0
        var result = -1
        for ((number, count) in cnt) {
            if (count > maxCount || (count == maxCount && number > result)) {
                maxCount = count
                result = number
            }
        }
        return result
    }
}
