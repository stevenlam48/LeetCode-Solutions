package decreaseelementstomakearrayzigzag

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DecreaseElementsToMakeArrayZigzagTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().movesToMakeZigzag(intArrayOf(1, 2, 3)))
    }

    @Test
    fun example2() {
        assertEquals(4, Solution().movesToMakeZigzag(intArrayOf(9, 6, 1, 6, 2)))
    }

    @Test
    fun alreadyZigzag() {
        assertEquals(0, Solution().movesToMakeZigzag(intArrayOf(2, 1, 2)))
    }

    @Test
    fun singleElement() {
        assertEquals(0, Solution().movesToMakeZigzag(intArrayOf(5)))
    }

    @Test
    fun twoElements() {
        assertEquals(1, Solution().movesToMakeZigzag(intArrayOf(1, 1)))
    }

    @Test
    fun allEqual() {
        assertEquals(1, Solution().movesToMakeZigzag(intArrayOf(2, 2, 2)))
    }
}
