package sumoftotalstrengthofwizards

// Time:  O(n)
// Space: O(n)

// mono stack, prefix sum, optimized from solution2
class Solution {
    fun totalStrength(strength: IntArray): Int {
        val MOD = 1e9.toInt() + 7
        val add = { a: Long, b: Long -> (a + b) % MOD }
        val sub = { a: Long, b: Long -> (a - b + MOD) % MOD }
        val mult = { a: Long, b: Long -> (a * b) % MOD }
        val prefix = LongArray(strength.size + 1)
        var curr = 0L
        for (i in strength.indices) {
            curr = add(curr, strength[i].toLong())
            prefix[i + 1] = add(prefix[i], curr)
        }
        val stk = ArrayList<Int>()
        stk.add(-1)
        var result = 0L
        for (i in 0..strength.size) {
            while (stk[stk.size - 1] != -1 && (i == strength.size || strength[stk[stk.size - 1]] >= strength[i])) {
                val x = stk[stk.size - 2] + 1
                val y = stk.removeAt(stk.size - 1)
                val z = i - 1
                result = add(
                    result,
                    mult(
                        strength[y].toLong(),
                        sub(
                            mult((y - x + 1).toLong(), sub(prefix[z + 1], prefix[y])),
                            mult((z - y + 1).toLong(), sub(prefix[y], prefix[maxOf(x - 1, 0)]))
                        )
                    )
                )
            }
            stk.add(i)
        }
        return result.toInt()
    }
}
