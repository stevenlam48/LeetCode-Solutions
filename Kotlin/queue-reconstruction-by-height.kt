package queuereconstructionbyheight

// Time:  O(n * sqrt(n))
// Space: O(n)

class Solution {
    fun reconstructQueue(people: Array<IntArray>): List<IntArray> {
        people.sortWith(Comparator { a, b ->
            if (b[0] == a[0]) a[1].compareTo(b[1]) else b[0].compareTo(a[0])
        })

        val blocks = mutableListOf<MutableList<IntArray>>(mutableListOf())
        for (p in people) {
            var index = p[1]
            var i = 0
            while (i < blocks.size) {
                if (index <= blocks[i].size) {
                    break
                }
                index -= blocks[i].size
                ++i
            }
            blocks[i].add(index, p)

            if (blocks[i].size * blocks[i].size > people.size) {
                val half = blocks[i].size / 2
                blocks.add(i + 1, blocks[i].subList(half, blocks[i].size).toMutableList())
                blocks[i].subList(half, blocks[i].size).clear()
            }
        }

        val result = mutableListOf<IntArray>()
        for (block in blocks) {
            for (p in block) {
                result.add(p)
            }
        }
        return result
    }
}
