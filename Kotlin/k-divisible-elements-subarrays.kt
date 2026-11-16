package kdivisibleelementssubarrays
// Time:  O(n^2)
// Space: O(t), t is the size of trie

class Solution {
    fun countDistinct(nums: IntArray, k: Int, p: Int): Int {
        val trie = Trie()
        for (i in nums.indices) {
            trie.insert(nums, i, k, p)
        }
        return trie.count()
    }

    private class Trie {
        private val nodes = mutableListOf<HashMap<Int, Int>>(hashMapOf())

        fun insert(nums: IntArray, i: Int, k: Int, p: Int) {
            var curr = 0
            var cnt = 0
            for (j in i until nums.size) {
                if (nums[j] % p == 0) {
                    ++cnt
                }
                if (cnt > k) {
                    break
                }
                if (!nodes[curr].containsKey(nums[j])) {
                    nodes[curr][nums[j]] = createNode()
                }
                curr = nodes[curr].getValue(nums[j])
            }
        }

        fun count(): Int = nodes.size - 1

        private fun createNode(): Int {
            nodes.add(hashMapOf())
            return nodes.size - 1
        }
    }
}
