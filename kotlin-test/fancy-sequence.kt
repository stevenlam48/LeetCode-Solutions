package fancysequence

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FancySequenceTest {
    @Test
    fun fullOperationSequenceExample() {
        val fancy = Fancy()
        fancy.append(2)
        fancy.addAll(3)
        fancy.append(7)
        fancy.multAll(2)
        assertEquals(10, fancy.getIndex(0))
        fancy.addAll(3)
        fancy.append(10)
        fancy.multAll(2)
        assertEquals(26, fancy.getIndex(0))
        assertEquals(34, fancy.getIndex(1))
        assertEquals(20, fancy.getIndex(2))
        assertEquals(-1, fancy.getIndex(3))
        assertEquals(-1, fancy.getIndex(4))
    }

    @Test
    fun invalidIndicesOnEmptyAndNonemptySequences() {
        val fancy = Fancy()
        assertEquals(-1, fancy.getIndex(0))
        assertEquals(-1, fancy.getIndex(3))
        fancy.append(8)
        assertEquals(8, fancy.getIndex(0))
        assertEquals(-1, fancy.getIndex(1))
    }

    @Test
    fun operationsBeforeAppendDoNotChangeAppendedValue() {
        val fancy = Fancy()
        fancy.addAll(5)
        fancy.multAll(3)
        fancy.append(2)
        assertEquals(2, fancy.getIndex(0))
    }

    @Test
    fun laterOperationsApplyToEarlierAndLaterValuesCorrectly() {
        val fancy = Fancy()
        fancy.append(4)
        fancy.addAll(6)
        fancy.multAll(2)
        assertEquals(20, fancy.getIndex(0))
        fancy.append(1)
        fancy.addAll(3)
        assertEquals(23, fancy.getIndex(0))
        assertEquals(4, fancy.getIndex(1))
    }

    @Test
    fun repeatedMultiplicationUsesModulo() {
        val fancy = Fancy()
        fancy.append(1)
        repeat(31) {
            fancy.multAll(2)
        }
        assertEquals(147_483_634, fancy.getIndex(0))
    }
}
