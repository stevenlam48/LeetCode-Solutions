package maximumandminimumsumsofatmostsizeksubsequences

// Time:  O(nlogn)
// Space: O(n)

private const val MOD = 1_000_000_007L
private val fact = mutableListOf(1L, 1L)
private val inv = mutableListOf(1L, 1L)
private val invFact = mutableListOf(1L, 1L)

private fun addMod(a: Long, initialB: Long): Long {
    var b = initialB
    if (MOD - a <= b) {
        b -= MOD
    }
    return a + b
}

private fun subMod(a: Long, b: Long): Long {
    return addMod(a, (MOD - b) % MOD)
}

private fun mulMod(initialA: Long, initialB: Long): Long {
    var a = initialA
    var b = initialB
    var result = 0L
    if (a < b) {
        val temp = a
        a = b
        b = temp
    }
    while (b > 0) {
        if (b and 1L != 0L) {
            result = addMod(result, a)
        }
        a = addMod(a, a)
        b = b shr 1
    }
    return result
}

private fun nCr(n: Int, k: Int): Long {
    if (n < k) {
        return 0L
    }
    while (inv.size <= n) {
        fact.add(mulMod(fact.last(), inv.size.toLong()))
        inv.add(mulMod(inv[(MOD % inv.size).toInt()], MOD - MOD / inv.size))
        invFact.add(mulMod(invFact.last(), inv.last()))
    }
    return mulMod(mulMod(fact[n], invFact[n - k]), invFact[k])
}

class Solution {
    fun minMaxSums(nums: IntArray, k: Int): Int {
        nums.sort()
        var result = 0L
        var cnt = 1L
        for (i in nums.indices) {
            result = addMod(result, mulMod(addMod(nums[i].toLong(), nums[nums.size - 1 - i].toLong()), cnt))
            cnt = subMod(mulMod(cnt, 2L), nCr(i, k - 1))
        }
        return result.toInt()
    }
}
