package lexicographicallylargestpowerarray

// Time:  O(l * n)
// Space: O(n)

class Solution {
    fun largestPower(nums: IntArray): IntArray {
        val L = 15

        val result = IntArray(L)
        val groups = ArrayList<MutableList<Int>>()
        groups.add(nums.toMutableList())
        for (i in L - 1 downTo 0) {
            var prefix = 0
            var j = 0
            while (j < groups.size) {
                val ones = ArrayList<Int>()
                for (x in groups[j]) {
                    if (x and (1 shl i) != 0) {
                        ones.add(x)
                    }
                }
                prefix += ones.size
                if (ones.size != groups[j].size) {
                    if (ones.isNotEmpty()) {
                        val zeros = ArrayList<Int>()
                        for (x in groups[j]) {
                            if (x and (1 shl i) == 0) {
                                zeros.add(x)
                            }
                        }
                        groups[j] = ones
                        groups.add(j + 1, zeros)
                    }
                    break
                }
                ++j
            }
            result[(L - 1) - i] = prefix
        }
        return result
    }
}
