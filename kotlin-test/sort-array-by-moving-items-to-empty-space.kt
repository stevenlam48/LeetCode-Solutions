package sortarraybymovingitemstoemptyspace

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SortArrayByMovingItemsToEmptySpaceTest {
    @Test
    fun alreadySortedAscending() {
        assertEquals(0, Solution().sortArray(intArrayOf(0, 1, 2)))
    }

    @Test
    fun alreadySortedWithEmptyAtEnd() {
        assertEquals(0, Solution().sortArray(intArrayOf(1, 2, 3, 0)))
    }

    @Test
    fun singleSwap() {
        val nums = intArrayOf(0, 2, 1)
        assertEquals(1, Solution().sortArray(nums))
        assertEquals(bruteForce(nums), Solution().sortArray(nums))
    }

    @Test
    fun sortedWithEmptyAtEndNeedsNoMoves() {
        val nums = intArrayOf(1, 0)
        assertEquals(0, Solution().sortArray(nums))
        assertEquals(bruteForce(nums), Solution().sortArray(nums))
    }

    @Test
    fun threeCycle() {
        val nums = intArrayOf(2, 0, 1)
        assertEquals(2, Solution().sortArray(nums))
        assertEquals(bruteForce(nums), Solution().sortArray(nums))
    }

    @Test
    fun reversedFour() {
        val nums = intArrayOf(3, 2, 1, 0)
        assertEquals(bruteForce(nums), Solution().sortArray(nums))
    }

    @Test
    fun scrambledFour() {
        val nums = intArrayOf(1, 3, 0, 2)
        assertEquals(bruteForce(nums), Solution().sortArray(nums))
    }
}

private fun bruteForce(nums: IntArray): Int {
    val n = nums.size
    val targets = listOf(List(n) { it }, List(n) { if (it == n - 1) 0 else it + 1 })
    val start = nums.toList()
    var best = Int.MAX_VALUE
    for (target in targets) {
        val dist = HashMap<List<Int>, Int>()
        val q = ArrayDeque<List<Int>>()
        dist[start] = 0
        q.addLast(start)
        while (q.isNotEmpty()) {
            val cur = q.removeFirst()
            if (cur == target) {
                best = minOf(best, dist.getValue(cur))
                break
            }
            val zero = cur.indexOf(0)
            for (j in 0 until n) {
                if (j == zero) {
                    continue
                }
                val next = cur.toMutableList()
                next[zero] = next[j]
                next[j] = 0
                if (!dist.containsKey(next)) {
                    dist[next] = dist.getValue(cur) + 1
                    q.addLast(next)
                }
            }
        }
    }
    return best
}
