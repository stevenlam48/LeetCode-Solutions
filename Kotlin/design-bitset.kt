package designbitset

// Time:  ctor:     O(n)
//        fix:      O(1)
//        unfix:    O(1)
//        flip:     O(1)
//        all:      O(1)
//        one:      O(1)
//        count:    O(1)
//        toString: O(n)
// Space: O(n)
class Bitset(size: Int) {
    private val lookup = BooleanArray(size)
    private var flip = false
    private var cnt = 0

    fun fix(idx: Int) {
        if (lookup[idx] == flip) {
            lookup[idx] = !lookup[idx]
            ++cnt
        }
    }

    fun unfix(idx: Int) {
        if (lookup[idx] != flip) {
            lookup[idx] = !lookup[idx]
            --cnt
        }
    }

    fun flip() {
        flip = !flip
        cnt = lookup.size - cnt
    }

    fun all(): Boolean = cnt == lookup.size

    fun one(): Boolean = cnt >= 1

    fun count(): Int = cnt

    override fun toString(): String {
        val result = CharArray(lookup.size) { '0' }
        for (i in result.indices) {
            result[i] = if (lookup[i] != flip) '1' else '0'
        }
        return String(result)
    }
}
