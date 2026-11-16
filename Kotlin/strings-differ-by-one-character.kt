package stringsdifferbyonecharacter
// Time:  O(n * m)
// Space: O(n)

class Solution {
    fun differByOne(dict: List<String>): Boolean {
        val hashes = IntArray(dict.size)
        for (i in dict.indices) {
            for (c in dict[i]) {
                hashes[i] = ((P * hashes[i] + (c - 'a')) % MOD).toInt()
            }
        }
        var base = 1L
        for (p in dict[0].length - 1 downTo 0) {
            val lookup = HashMap<Int, MutableList<Int>>()
            for (i in dict.indices) {
                val newHash = ((hashes[i] - base * (dict[i][p] - 'a') % MOD) + MOD) % MOD
                val target = dict[i].substring(0, p) + dict[i].substring(p + 1)
                for (j in lookup[newHash.toInt()].orEmpty()) {
                    val candidate = dict[j].substring(0, p) + dict[j].substring(p + 1)
                    if (candidate == target) {
                        return true
                    }
                }
                lookup.getOrPut(newHash.toInt()) { mutableListOf() }.add(i)
            }
            base = P * base % MOD
        }
        return false
    }

    private companion object {
        const val MOD = 1_000_000_007L
        const val P = 113L
    }
}
