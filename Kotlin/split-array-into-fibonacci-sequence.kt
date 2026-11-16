package splitarrayintofibonaccisequence
// Time:  O(n^3)
// Space: O(n)

class Solution {
    fun splitIntoFibonacci(S: String): IntArray {
        var a = 0
        var i = 0
        while (i + 2 < S.length) {
            a = 10 * a + (S[i] - '0')
            var b = 0
            var j = i + 1
            while (j + 1 < S.length) {
                b = 10 * b + (S[j] - '0')
                val fib = mutableListOf(a, b)
                var k = j + 1
                while (k < S.length) {
                    if (fib[fib.size - 2] > Int.MAX_VALUE - fib[fib.size - 1]) {
                        break
                    }
                    val c = fib[fib.size - 2] + fib[fib.size - 1]
                    val l = startswith(S, k, c)
                    if (l == 0) {
                        break
                    }
                    fib.add(c)
                    k += l
                }
                if (k == S.length) {
                    return fib.toIntArray()
                }
                if (b == 0) {
                    break
                }
                ++j
            }
            if (a == 0) {
                break
            }
            ++i
        }
        return intArrayOf()
    }

    private fun startswith(S: String, k: Int, x: Int): Int {
        var y = 0
        for (i in k until S.length) {
            y = 10 * y + (S[i] - '0')
            if (y == x) {
                return i - k + 1
            } else if (y > x) {
                break
            }
        }
        return 0
    }
}
