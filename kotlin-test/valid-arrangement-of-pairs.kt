package validarrangementofpairs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ValidArrangementOfPairsTest {
    @Test
    fun openTrail() {
        val pairs = arrayOf(intArrayOf(5, 1), intArrayOf(4, 5), intArrayOf(11, 9), intArrayOf(9, 4))
        assertArrangement(pairs, Solution().validArrangement(pairs))
    }

    @Test
    fun closedCircuit() {
        val pairs = arrayOf(intArrayOf(1, 3), intArrayOf(3, 2), intArrayOf(2, 1))
        assertArrangement(pairs, Solution().validArrangement(pairs))
    }

    @Test
    fun parallelEdges() {
        val pairs = arrayOf(intArrayOf(1, 2), intArrayOf(1, 2), intArrayOf(2, 1))
        assertArrangement(pairs, Solution().validArrangement(pairs))
    }

    @Test
    fun singlePair() {
        val pairs = arrayOf(intArrayOf(7, 9))
        assertArrangement(pairs, Solution().validArrangement(pairs))
    }
}

private fun assertArrangement(pairs: Array<IntArray>, actual: Array<IntArray>) {
    assertEquals(pairs.size, actual.size)
    for (i in 1 until actual.size) {
        assertEquals(actual[i - 1][1], actual[i][0])
    }
    val remaining = pairs.map { it.toList() }.groupingBy { it }.eachCount().toMutableMap()
    for (pair in actual) {
        val key = pair.toList()
        val count = remaining[key] ?: 0
        assertTrue(count > 0)
        if (count == 1) {
            remaining.remove(key)
        } else {
            remaining[key] = count - 1
        }
    }
    assertTrue(remaining.isEmpty())
}
