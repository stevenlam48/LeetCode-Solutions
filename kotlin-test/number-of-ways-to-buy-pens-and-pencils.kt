package numberofwaystobuypensandpencils

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfWaysToBuyPensAndPencilsTest {
    @Test
    fun example1() {
        assertEquals(9L, Solution().waysToBuyPensPencils(20, 10, 5))
    }

    @Test
    fun example2() {
        assertEquals(1L, Solution().waysToBuyPensPencils(5, 10, 10))
    }

    @Test
    fun mixedCosts() {
        assertEquals(14L, Solution().waysToBuyPensPencils(10, 2, 3))
    }

    @Test
    fun unitCosts() {
        assertEquals(3L, Solution().waysToBuyPensPencils(1, 1, 1))
    }

    @Test
    fun zeroTotal() {
        assertEquals(1L, Solution().waysToBuyPensPencils(0, 1, 1))
    }
}
