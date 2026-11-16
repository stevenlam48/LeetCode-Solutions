package smallestnumberininfiniteset

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SmallestNumberInInfiniteSetTest {
    @Test
    fun exampleOperationSequence() {
        val set = SmallestInfiniteSet()
        set.addBack(2)
        assertEquals(1, set.popSmallest())
        assertEquals(2, set.popSmallest())
        assertEquals(3, set.popSmallest())
        set.addBack(1)
        assertEquals(1, set.popSmallest())
        assertEquals(4, set.popSmallest())
        assertEquals(5, set.popSmallest())
    }

    @Test
    fun duplicateAddBackOnlyReturnsNumberOnce() {
        val set = SmallestInfiniteSet()
        assertEquals(1, set.popSmallest())
        assertEquals(2, set.popSmallest())
        set.addBack(1)
        set.addBack(1)
        assertEquals(1, set.popSmallest())
        assertEquals(3, set.popSmallest())
    }

    @Test
    fun addedNumbersAreReturnedInOrder() {
        val set = SmallestInfiniteSet()
        assertEquals(1, set.popSmallest())
        assertEquals(2, set.popSmallest())
        assertEquals(3, set.popSmallest())
        set.addBack(2)
        set.addBack(1)
        set.addBack(3)
        assertEquals(1, set.popSmallest())
        assertEquals(2, set.popSmallest())
        assertEquals(3, set.popSmallest())
        assertEquals(4, set.popSmallest())
    }
}
