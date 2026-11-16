package groupsofstrings

// Time:  O(26 * n)
// Space: O(26 * n)

// bitmasks, union find
class Solution {
    fun groupStrings(words: List<String>): IntArray {
        val uf = UnionFind(words.size)
        val lookup = HashMap<Int, Int>()
        for (i in words.indices) {
            var mask = 0
            for (x in words[i]) {
                mask = mask or (1 shl (x - 'a'))
            }
            if (!lookup.containsKey(mask)) {
                lookup[mask] = i
            }
            uf.unionSet(i, lookup.getValue(mask))
            var bit = 1
            while (bit <= mask) {
                if ((mask and bit) != 0) {
                    if (!lookup.containsKey(mask xor bit)) {
                        lookup[mask xor bit] = i
                    }
                    uf.unionSet(i, lookup.getValue(mask xor bit))
                }
                bit = bit shl 1
            }
        }
        return intArrayOf(uf.total(), uf.maxSize())
    }

    private class UnionFind(n: Int) {
        private val set = IntArray(n) { it }
        private val rank = IntArray(n)
        private val size = IntArray(n) { 1 }
        private var total = n

        fun findSet(xIn: Int): Int {
            var x = xIn
            if (set[x] != x) {
                set[x] = findSet(set[x])
            }
            return set[x]
        }

        fun unionSet(xIn: Int, yIn: Int): Boolean {
            var x = findSet(xIn)
            var y = findSet(yIn)
            if (x == y) {
                return false
            }
            if (rank[x] > rank[y]) {
                val tmp = x
                x = y
                y = tmp
            }
            set[x] = y
            if (rank[x] == rank[y]) {
                ++rank[y]
            }
            size[y] += size[x]
            --total
            return true
        }

        fun maxSize(): Int = size.max()

        fun total(): Int = total
    }
}
