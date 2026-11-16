package countanagrams

// Time:  O(n)
// Space: O(n)

class Solution {
    fun countAnagrams(s: String): Int {
        val MOD = 1_000_000_007L
        val fact = mutableListOf(1, 1)
        val inv = mutableListOf(1, 1)
        val invFact = mutableListOf(1, 1)

        fun lazyInit(n: Int) {
            while (inv.size <= n) {
                val sz = inv.size
                fact.add((fact.last().toLong() * sz % MOD).toInt())
                inv.add((inv[(MOD % sz).toInt()].toLong() * (MOD - MOD / sz) % MOD).toInt())
                invFact.add((invFact.last().toLong() * inv.last() % MOD).toInt())
            }
        }

        fun factorial(n: Int): Int {
            lazyInit(n)
            return fact[n]
        }

        fun invFactorial(n: Int): Int {
            lazyInit(n)
            return invFact[n]
        }

        fun count(j: Int, i: Int): Int {
            val cnt = IntArray(26)
            for (k in j..i) {
                ++cnt[s[k] - 'a']
            }
            var result = 1L
            var total = 0
            for (c in cnt) {
                total += c
                result = result * invFactorial(c) % MOD
            }
            return (result * factorial(total) % MOD).toInt()
        }

        var result = 1L
        var j = 0
        for (i in s.indices) {
            if (i + 1 != s.length && s[i + 1] != ' ') {
                continue
            }
            result = result * count(j, i) % MOD
            j = i + 2
        }
        return result.toInt()
    }
}
