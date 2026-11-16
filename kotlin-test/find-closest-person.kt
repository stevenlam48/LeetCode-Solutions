package findclosestperson

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindClosestPersonTest {
    @Test
    fun firstPersonCloser() {
        assertEquals(1, Solution().findClosest(2, 7, 4))
    }

    @Test
    fun secondPersonCloser() {
        assertEquals(2, Solution().findClosest(2, 5, 6))
    }

    @Test
    fun tie() {
        assertEquals(0, Solution().findClosest(1, 5, 3))
    }

    @Test
    fun secondPersonCloserOnRight() {
        assertEquals(2, Solution().findClosest(1, 2, 3))
    }

    @Test
    fun samePosition() {
        assertEquals(0, Solution().findClosest(4, 4, 4))
    }
}
