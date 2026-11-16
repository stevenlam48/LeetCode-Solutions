package pancakesorting

// Time:  O(nlogn)
// Space: O(n)

// bit solution
class Solution {
    fun pancakeSort(arr: IntArray): IntArray {
        val bit = BIT(arr.size)
        val result = ArrayList<Int>()
        for (i in arr.indices) {
            val n = bit.query((arr[i] - 1) - 1)
            bit.add(arr[i] - 1, 1)
            if (n == i) {
                continue
            }
            if (n == 0) {
                if (i > 1) {
                    result.add(i)
                }
                result.add(i + 1)
            } else {
                if (n > 1) {
                    result.add(n)
                }
                result.add(i)
                result.add(i + 1)
                result.add(n + 1)
            }
        }
        return result.toIntArray()
    }

    private class BIT(n: Int) {
        private val bit = IntArray(n + 1)

        fun add(i0: Int, value: Int) {
            var i = i0 + 1
            while (i < bit.size) {
                bit[i] += value
                i += i and -i
            }
        }

        fun query(i0: Int): Int {
            var i = i0 + 1
            var total = 0
            while (i > 0) {
                total += bit[i]
                i -= i and -i
            }
            return total
        }
    }
}
