package findthemiddleindexinarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheMiddleIndexInArrayTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().findMiddleIndex(intArrayOf(2, 3, -1, 8, 4)))
    }

    @Test
    fun example2() {
        assertEquals(2, Solution().findMiddleIndex(intArrayOf(1, -1, 4)))
    }

    @Test
    fun example3() {
        assertEquals(-1, Solution().findMiddleIndex(intArrayOf(2, 5)))
    }

    @Test
    fun singleElement() {
        assertEquals(0, Solution().findMiddleIndex(intArrayOf(1)))
    }
}
