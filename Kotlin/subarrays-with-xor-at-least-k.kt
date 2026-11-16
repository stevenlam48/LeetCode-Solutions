package subarrayswithxoratleastk

// Time:  O(nlogr), r = max(max(nums), k, 1)
// Space: O(t)

// bitmasks, prefix sum, trie
class Solution {
    private class Trie(private val bitLength: Int) {
        private val nodes = mutableListOf<IntArray>()
        private val cnts = mutableListOf<Int>()

        init {
            newNode()
        }

        fun add(num: Int) {
            var curr = 0
            for (i in bitLength - 1 downTo 0) {
                val x = (num shr i) and 1
                if (nodes[curr][x] == -1) {
                    nodes[curr][x] = newNode()
                }
                curr = nodes[curr][x]
                ++cnts[curr]
            }
        }

        fun query(prefix: Int, k: Int): Int {
            var result = 0
            var curr = 0
            var i = bitLength - 1
            while (i >= 0 && curr != -1) {
                val t = (k shr i) and 1
                val x = (prefix shr i) and 1
                if (t == 0) {
                    val tmp = nodes[curr][1 xor x]
                    if (tmp != -1) {
                        result += cnts[tmp]
                    }
                }
                curr = nodes[curr][t xor x]
                --i
            }
            if (curr != -1) {
                result += cnts[curr]
            }
            return result
        }

        private fun newNode(): Int {
            nodes.add(intArrayOf(-1, -1))
            cnts.add(0)
            return nodes.size - 1
        }
    }

    fun countXorSubarrays(nums: IntArray, k: Int): Long {
        var result = 0L
        var prefix = 0
        val mx = maxOf(nums.max(), k, 1)
        val trie = Trie(if (mx != 0) 32 - Integer.numberOfLeadingZeros(mx) else 0)
        trie.add(prefix)
        for (x in nums) {
            prefix = prefix xor x
            result += trie.query(prefix, k)
            trie.add(prefix)
        }
        return result
    }
}
