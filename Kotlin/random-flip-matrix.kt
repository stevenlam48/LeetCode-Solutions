package randomflipmatrix

// Time:  ctor:  O(1)
//        flip:  O(1)
//        reset: O(min(f, r * c))
// Space: O(min(f, r * c))

class Solution(private val nRows: Int, private val nCols: Int) {
    private var n = nRows * nCols
    private val lookup = HashMap<Int, Int>()
    private val gen = java.util.Random()

    fun flip(): IntArray {
        --n
        val target = gen.nextInt(n + 1)
        val x = get(target, target)
        lookup[target] = get(n, n)
        return intArrayOf(x / nCols, x % nCols)
    }

    fun reset() {
        lookup.clear()
        n = nRows * nCols
    }

    private fun get(key: Int, defaultValue: Int): Int {
        return lookup[key] ?: defaultValue
    }
}
