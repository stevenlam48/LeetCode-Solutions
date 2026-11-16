package minimumdaystoscoreexactlynpoints

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumDaysToScoreExactlyNPointsTest {
    @Test
    fun n1() {
        assertEquals(1, Solution().minDays(1))
    }

    @Test
    fun n2() {
        assertEquals(3, Solution().minDays(2))
    }

    @Test
    fun n3() {
        assertEquals(2, Solution().minDays(3))
    }

    @Test
    fun n4() {
        assertEquals(4, Solution().minDays(4))
    }

    @Test
    fun n6() {
        assertEquals(3, Solution().minDays(6))
    }

    @Test
    fun n10() {
        assertEquals(4, Solution().minDays(10))
    }
}
