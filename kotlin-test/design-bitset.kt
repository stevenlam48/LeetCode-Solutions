package designbitset

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DesignBitsetTest {
    @Test
    fun exampleSequence() {
        val bitset = Bitset(5)
        bitset.fix(3)
        bitset.fix(1)
        bitset.flip()
        assertFalse(bitset.all())
        bitset.unfix(0)
        bitset.flip()
        assertTrue(bitset.one())
        assertFalse(bitset.all())
        assertEquals(3, bitset.count())
        bitset.fix(2)
        bitset.fix(4)
        assertTrue(bitset.all())
        assertEquals(5, bitset.count())
        assertEquals("11111", bitset.toString())
    }

    @Test
    fun duplicateFixAndUnfixDoNotChangeCount() {
        val bitset = Bitset(3)
        bitset.fix(1)
        bitset.fix(1)
        assertEquals(1, bitset.count())
        bitset.unfix(1)
        bitset.unfix(1)
        assertEquals(0, bitset.count())
        assertFalse(bitset.one())
    }

    @Test
    fun repeatedFlipsPreserveLogicalBits() {
        val bitset = Bitset(4)
        bitset.fix(0)
        bitset.fix(2)
        bitset.flip()
        assertEquals("0101", bitset.toString())
        assertEquals(2, bitset.count())
        bitset.flip()
        assertEquals("1010", bitset.toString())
        assertEquals(2, bitset.count())
    }

    @Test
    fun zeroSizeIsEmptyAndAll() {
        val bitset = Bitset(0)
        assertTrue(bitset.all())
        assertFalse(bitset.one())
        assertEquals(0, bitset.count())
        assertEquals("", bitset.toString())
        bitset.flip()
        assertTrue(bitset.all())
    }
}
