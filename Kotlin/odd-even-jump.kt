package oddevenjump

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun oddEvenJumps(A: IntArray): Int {
        val n = A.size
        val idx = (0 until n).toMutableList()

        idx.sortWith(Comparator<Int> { a, b -> if (A[a] != A[b]) A[a].compareTo(A[b]) else a.compareTo(b) })
        val nextHigher = findNext(idx)
        idx.sortWith(Comparator<Int> { a, b -> if (A[a] != A[b]) A[b].compareTo(A[a]) else a.compareTo(b) })
        val nextLower = findNext(idx)

        val odd = BooleanArray(n)
        val even = BooleanArray(n)
        odd[n - 1] = true
        even[n - 1] = true
        for (i in n - 2 downTo 0) {
            if (nextHigher[i] != -1) {
                odd[i] = even[nextHigher[i]]
            }
            if (nextLower[i] != -1) {
                even[i] = odd[nextLower[i]]
            }
        }
        return odd.count { it }
    }

    private fun findNext(idx: List<Int>): IntArray {
        val result = IntArray(idx.size) { -1 }
        val stack = ArrayDeque<Int>()
        for (i in idx) {
            while (stack.isNotEmpty() && stack.last() < i) {
                result[stack.last()] = i
                stack.removeLast()
            }
            stack.addLast(i)
        }
        return result
    }
}
