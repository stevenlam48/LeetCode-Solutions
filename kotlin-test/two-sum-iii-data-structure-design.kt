package twosumiiidatastructuredesign

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class TwoSumIiiDataStructureDesignTest {
    @Test
    fun exampleSequence() {
        val twoSum = TwoSum()
        twoSum.add(1)
        twoSum.add(3)
        twoSum.add(5)
        assertTrue(twoSum.find(4))
        assertFalse(twoSum.find(7))
    }

    @Test
    fun needsTwoCopies() {
        val twoSum = TwoSum()
        twoSum.add(0)
        assertFalse(twoSum.find(0))
        twoSum.add(0)
        assertTrue(twoSum.find(0))
    }

    @Test
    fun negatives() {
        val twoSum = TwoSum()
        twoSum.add(-1)
        twoSum.add(2)
        assertTrue(twoSum.find(1))
        assertFalse(twoSum.find(-2))
    }

    @Test
    fun empty() {
        assertFalse(TwoSum().find(0))
    }
}
