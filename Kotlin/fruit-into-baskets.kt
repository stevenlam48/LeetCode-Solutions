package fruitintobaskets

// Time:  O(n)
// Space: O(1)

class Solution {
    fun totalFruit(tree: IntArray): Int {
        val count = HashMap<Int, Int>()
        var result = 0
        var i = 0
        for (j in tree.indices) {
            count[tree[j]] = (count[tree[j]] ?: 0) + 1
            while (count.size > 2) {
                val c = count[tree[i]]!! - 1
                if (c == 0) {
                    count.remove(tree[i])
                } else {
                    count[tree[i]] = c
                }
                ++i
            }
            result = maxOf(result, j - i + 1)
        }
        return result
    }
}
