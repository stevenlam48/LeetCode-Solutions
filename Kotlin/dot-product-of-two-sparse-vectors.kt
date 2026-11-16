package dotproductoftwosparsevectors

// Time:  ctor: O(n)
//        dot_product: O(min(n, m))
// Space: O(n)

class SparseVector(nums: IntArray) {
    private val lookup = HashMap<Int, Int>()

    init {
        for (i in nums.indices) {
            if (nums[i] != 0) {
                lookup[i] = nums[i]
            }
        }
    }

    fun dotProduct(vec: SparseVector): Int {
        var a = this
        var b = vec
        if (a.lookup.size > b.lookup.size) {
            val t = a
            a = b
            b = t
        }
        var result = 0
        for ((i, v) in a.lookup) {
            if (b.lookup.containsKey(i)) {
                result += v * b.lookup[i]!!
            }
        }
        return result
    }
}
