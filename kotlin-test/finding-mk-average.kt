package findingmkaverage

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindingMkAverageTest {
    @Test
    fun matchesLeetCodeOperationSequence() {
        val mkAverage = MKAverage(3, 1)
        mkAverage.addElement(3)
        mkAverage.addElement(1)
        assertEquals(-1, mkAverage.calculateMKAverage())
        mkAverage.addElement(10)
        assertEquals(3, mkAverage.calculateMKAverage())
        mkAverage.addElement(5)
        assertEquals(5, mkAverage.calculateMKAverage())
        mkAverage.addElement(5)
        assertEquals(5, mkAverage.calculateMKAverage())
        mkAverage.addElement(5)
        assertEquals(5, mkAverage.calculateMKAverage())
    }

    @Test
    fun removesValuesFromEachPartition() {
        val mkAverage = MKAverage(5, 1)
        for (value in intArrayOf(1, 2, 3, 4)) {
            mkAverage.addElement(value)
        }
        assertEquals(-1, mkAverage.calculateMKAverage())
        mkAverage.addElement(5)
        assertEquals(3, mkAverage.calculateMKAverage())
        mkAverage.addElement(10)
        assertEquals(4, mkAverage.calculateMKAverage())
        mkAverage.addElement(1)
        assertEquals(4, mkAverage.calculateMKAverage())
    }

    @Test
    fun handlesDuplicateAndLargerRemovalCounts() {
        val mkAverage = MKAverage(7, 2)
        for (value in 1..7) {
            mkAverage.addElement(value)
        }
        assertEquals(4, mkAverage.calculateMKAverage())
        mkAverage.addElement(8)
        assertEquals(5, mkAverage.calculateMKAverage())
        mkAverage.addElement(0)
        assertEquals(5, mkAverage.calculateMKAverage())
    }

    @Test
    fun usesLongForTheMiddleSumAndHandlesDuplicates() {
        val mkAverage = MKAverage(3, 1)
        repeat(3) {
            mkAverage.addElement(2_000_000_000)
        }
        assertEquals(2_000_000_000, mkAverage.calculateMKAverage())
        mkAverage.addElement(2_000_000_000)
        assertEquals(2_000_000_000, mkAverage.calculateMKAverage())
    }
}
