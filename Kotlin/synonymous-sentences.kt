package synonymoussentences
// Time:  O(p*l * log(p*l)), p is the production of all number of synonyms
//                         , l is the length of a word
// Space: O(p*l)

class Solution {
    fun generateSentences(synonyms: List<List<String>>, text: String): List<String> {
        val lookup = HashMap<String, Int>()
        val invLookup = HashMap<Int, String>()
        for (synonym in synonyms) {
            assignId(synonym[0], lookup, invLookup)
            assignId(synonym[1], lookup, invLookup)
        }
        val unionFind = UnionFind(lookup.size)
        for (synonym in synonyms) {
            unionFind.unionSet(lookup[synonym[0]]!!, lookup[synonym[1]]!!)
        }
        val groups = HashMap<Int, MutableList<Int>>()
        for (i in unionFind.set().indices) {
            groups.getOrPut(unionFind.findSet(i)) { mutableListOf() }.add(i)
        }
        val result = mutableListOf<List<String>>()
        for (word in text.split(' ').filter { it.isNotEmpty() }) {
            if (word !in lookup) {
                result.add(listOf(word))
                continue
            }
            val options = groups[unionFind.findSet(lookup[word]!!)]!!
                .map { invLookup[it]!! }
                .sorted()
            result.add(options)
        }
        return product(result)
    }

    private fun assignId(x: String, lookup: HashMap<String, Int>, invLookup: HashMap<Int, String>) {
        if (x in lookup) {
            return
        }
        lookup[x] = lookup.size
        invLookup[lookup[x]!!] = x
    }

    private fun product(options: List<List<String>>): List<String> {
        val result = mutableListOf<String>()
        var total = 1
        for (option in options) {
            total *= option.size
        }
        for (i in 0 until total) {
            val tmp = mutableListOf<String>()
            var curr = i
            for (j in options.indices.reversed()) {
                tmp.add(options[j][curr % options[j].size])
                curr /= options[j].size
            }
            tmp.reverse()
            result.add(tmp.joinToString(" "))
        }
        return result
    }

    private class UnionFind(n: Int) {
        private val set = IntArray(n) { it }

        fun findSet(x: Int): Int {
            if (set[x] != x) {
                set[x] = findSet(set[x])
            }
            return set[x]
        }

        fun unionSet(x: Int, y: Int): Boolean {
            val xRoot = findSet(x)
            val yRoot = findSet(y)
            if (xRoot == yRoot) {
                return false
            }
            set[minOf(xRoot, yRoot)] = maxOf(xRoot, yRoot)
            return true
        }

        fun set(): IntArray = set
    }
}
