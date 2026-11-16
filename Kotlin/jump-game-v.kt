package jumpgamev
// Time:  O(n)
// Space: O(n)

import java.util.ArrayDeque

class Solution {
    fun maxJumps(arr: IntArray, d: Int): Int {
        val left = Array(arr.size) { mutableListOf<Int>() }
        var decreasingDq = ArrayDeque<Int>()
        for (i in arr.indices) {
            if (decreasingDq.isNotEmpty() && i - decreasingDq.first() == d + 1) {
                decreasingDq.removeFirst()
            }
            while (decreasingDq.isNotEmpty() && arr[decreasingDq.last()] < arr[i]) {
                if (left[i].isNotEmpty() && arr[left[i].last()] != arr[decreasingDq.last()]) {
                    left[i].clear()
                }
                left[i].add(decreasingDq.last())
                decreasingDq.removeLast()
            }
            decreasingDq.addLast(i)
        }
        val right = Array(arr.size) { mutableListOf<Int>() }
        decreasingDq = ArrayDeque()
        for (i in arr.size - 1 downTo 0) {
            if (decreasingDq.isNotEmpty() && decreasingDq.first() - i == d + 1) {
                decreasingDq.removeFirst()
            }
            while (decreasingDq.isNotEmpty() && arr[decreasingDq.last()] < arr[i]) {
                if (right[i].isNotEmpty() && arr[right[i].last()] != arr[decreasingDq.last()]) {
                    right[i].clear()
                }
                right[i].add(decreasingDq.last())
                decreasingDq.removeLast()
            }
            decreasingDq.addLast(i)
        }

        var result = 0
        val lookup = IntArray(arr.size)
        for (i in arr.indices) {
            result = maxOf(result, dp(arr, i, left, right, lookup))
        }
        return result
    }

    private fun dp(
        arr: IntArray,
        i: Int,
        left: Array<MutableList<Int>>,
        right: Array<MutableList<Int>>,
        lookup: IntArray
    ): Int {
        if (lookup[i] != 0) {
            return lookup[i]
        }
        lookup[i] = 1
        for (j in left[i]) {
            lookup[i] = maxOf(lookup[i], dp(arr, j, left, right, lookup) + 1)
        }
        for (j in right[i]) {
            lookup[i] = maxOf(lookup[i], dp(arr, j, left, right, lookup) + 1)
        }
        return lookup[i]
    }
}
