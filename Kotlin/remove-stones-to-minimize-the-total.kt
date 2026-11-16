package removestonestominimizethetotal
// Time:  O(n + klogn)
// Space: O(1)

class Solution {
    fun minStoneSum(piles: IntArray, k: Int): Int {
        for (i in piles.size / 2 - 1 downTo 0) {
            siftDown(piles, i, piles.size)
        }
        repeat(k) {
            val x = piles[0]
            val last = piles.lastIndex
            piles[0] = piles[last]
            siftDown(piles, 0, last)
            piles[last] = (x + 1) / 2
            var i = last
            while (i > 0) {
                val parent = (i - 1) / 2
                if (piles[parent] >= piles[i]) {
                    break
                }
                swap(piles, parent, i)
                i = parent
            }
        }
        return piles.sum()
    }

    private fun siftDown(piles: IntArray, index: Int, size: Int) {
        var i = index
        while (2 * i + 1 < size) {
            var child = 2 * i + 1
            if (child + 1 < size && piles[child + 1] > piles[child]) {
                ++child
            }
            if (piles[i] >= piles[child]) {
                break
            }
            swap(piles, i, child)
            i = child
        }
    }

    private fun swap(piles: IntArray, i: Int, j: Int) {
        val tmp = piles[i]
        piles[i] = piles[j]
        piles[j] = tmp
    }
}
