package dividetwointegers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DivideTwoIntegersTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().divide(10, 3))
    }

    @Test
    fun example2() {
        assertEquals(-2, Solution().divide(7, -3))
    }

    @Test
    fun zeroDividend() {
        assertEquals(0, Solution().divide(0, 1))
    }

    @Test
    fun overflowCase() {
        assertEquals(Int.MAX_VALUE, Solution().divide(Int.MIN_VALUE, -1))
    }

    @Test
    fun minValueByOne() {
        assertEquals(Int.MIN_VALUE, Solution().divide(Int.MIN_VALUE, 1))
    }

    @Test
    fun maxValueByOne() {
        assertEquals(Int.MAX_VALUE, Solution().divide(Int.MAX_VALUE, 1))
    }
}
