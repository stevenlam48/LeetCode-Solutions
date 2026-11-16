package findingpairswithacertainsum

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FindingPairsWithACertainSumTest {
    @Test
    fun operationSequence() {
        val pairs = FindSumPairs(intArrayOf(1, 1, 2, 2), intArrayOf(1, 2, 3, 4, 5))
        assertEquals(2, pairs.count(7))
        pairs.add(3, 2)
        assertEquals(2, pairs.count(8))
        assertEquals(4, pairs.count(4))
        pairs.add(0, 1)
        assertEquals(2, pairs.count(5))
        assertEquals(6, pairs.count(4))
    }

    @Test
    fun duplicateFrequenciesAndZeroChange() {
        val pairs = FindSumPairs(intArrayOf(1, 1, 1), intArrayOf(2, 2, 3))
        assertEquals(6, pairs.count(3))
        assertEquals(3, pairs.count(4))
        pairs.add(2, 0)
        assertEquals(3, pairs.count(4))
    }

    @Test
    fun repeatedUpdatesToSameIndex() {
        val pairs = FindSumPairs(intArrayOf(1), intArrayOf(2, 4))
        assertEquals(1, pairs.count(3))
        pairs.add(0, 1)
        assertEquals(0, pairs.count(3))
        assertEquals(1, pairs.count(4))
        pairs.add(0, -2)
        assertEquals(1, pairs.count(2))
        assertEquals(0, pairs.count(4))
    }

    @Test
    fun negativeValuesAndZeroTotal() {
        val pairs = FindSumPairs(intArrayOf(-1, 0, 0, 2), intArrayOf(-2, 0, 1))
        assertEquals(4, pairs.count(0))
        pairs.add(1, -2)
        assertEquals(3, pairs.count(0))
    }
}
