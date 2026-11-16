package minimumpairremovaltosortarrayi

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun minimumPairRemoval(nums: IntArray): Int {
        val arr = LongArray(nums.size) { nums[it].toLong() }
        val left = IntArray(arr.size + 1) { it - 1 }
        val right = IntArray(arr.size) { it + 1 }
        var cnt = 0
        val bst = java.util.TreeSet<Pair<Long, Int>>(compareBy<Pair<Long, Int>>({ it.first }, { it.second }))

        fun add(i: Int) {
            if (i >= 0 && i < right[i] && right[i] < arr.size) {
                bst.add(arr[i] + arr[right[i]] to i)
                if (arr[i] > arr[right[i]]) {
                    ++cnt
                }
            }
        }

        fun remove(i: Int) {
            if (i >= 0 && i < right[i] && right[i] < arr.size) {
                bst.remove(arr[i] + arr[right[i]] to i)
                if (arr[i] > arr[right[i]]) {
                    --cnt
                }
            }
        }

        for (i in 0 until arr.size - 1) {
            bst.add(arr[i] + arr[i + 1] to i)
            if (arr[i] > arr[i + 1]) {
                ++cnt
            }
        }
        var result = 0
        while (cnt != 0) {
            val i = bst.first().second
            remove(left[i])
            remove(i)
            remove(right[i])
            arr[i] += arr[right[i]]
            left[right[right[i]]] = i
            right[i] = right[right[i]]
            add(left[i])
            add(i)
            ++result
        }
        return result
    }
}
