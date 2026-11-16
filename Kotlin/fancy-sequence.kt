package fancysequence

// Time:  O(1)
// Space: O(n)

class Fancy {
    private val arr = ArrayList<Int>()
    private val ops = arrayListOf(intArrayOf(1, 0))

    fun append(value: Int) {
        arr.add(value)
        ops.add(ops.last().copyOf())
    }

    fun addAll(inc: Int) {
        ops.last()[1] = addmod(ops.last()[1], inc, MOD)
    }

    fun multAll(m: Int) {
        ops.last()[0] = mulmod(ops.last()[0], m, MOD)
        ops.last()[1] = mulmod(ops.last()[1], m, MOD)
    }

    fun getIndex(idx: Int): Int {
        if (idx >= arr.size) {
            return -1
        }
        val op1 = ops[idx]
        val op2 = ops.last()
        val a = mulmod(op2[0], powmod(op1[0], MOD - 2, MOD), MOD)
        val b = submod(op2[1], mulmod(a, op1[1], MOD), MOD)
        return addmod(mulmod(arr[idx], a, MOD), b, MOD)
    }

    private fun addmod(a: Int, b: Int, mod: Int): Int {
        var b = b
        if (mod - a <= b) {
            b -= mod
        }
        return a + b
    }

    private fun submod(a: Int, b: Int, mod: Int): Int {
        return addmod(a, mod - b, mod)
    }

    private fun mulmod(a: Int, b: Int, mod: Int): Int {
        var a = a
        var b = b
        var result = 0
        if (a < b) {
            val temp = a
            a = b
            b = temp
        }
        while (b > 0) {
            if (b % 2 == 1) {
                result = addmod(result, a, mod)
            }
            a = addmod(a, a, mod)
            b /= 2
        }
        return result
    }

    private fun powmod(a: Int, b: Int, mod: Int): Int {
        var a = a
        var b = b
        a %= mod
        var result = 1
        while (b > 0) {
            if (b and 1 == 1) {
                result = mulmod(result, a, mod)
            }
            a = mulmod(a, a, mod)
            b = b shr 1
        }
        return result
    }

    companion object {
        private const val MOD = 1_000_000_007
    }
}
