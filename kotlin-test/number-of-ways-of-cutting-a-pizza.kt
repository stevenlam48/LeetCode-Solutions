package numberofwaysofcuttingapizza

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfWaysOfCuttingAPizzaTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().ways(listOf("A..", "AAA", "..."), 3))
    }

    @Test
    fun example2() {
        assertEquals(1, Solution().ways(listOf("A..", "AA.", "..."), 3))
    }

    @Test
    fun example3() {
        assertEquals(1, Solution().ways(listOf("A..", "A..", "..."), 1))
    }

    @Test
    fun noApple() {
        assertEquals(0, Solution().ways(listOf("...", "...", "..."), 2))
    }
}
