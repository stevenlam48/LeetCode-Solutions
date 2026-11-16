package firstbadversion

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FirstBadVersionTest {
    private fun solution(bad: Int) = Solution { it >= bad }

    @Test
    fun example() {
        assertEquals(4, solution(4).firstBadVersion(5))
    }

    @Test
    fun firstVersionIsBad() {
        assertEquals(1, solution(1).firstBadVersion(5))
    }

    @Test
    fun lastVersionIsBad() {
        assertEquals(5, solution(5).firstBadVersion(5))
    }

    @Test
    fun singleVersion() {
        assertEquals(1, solution(1).firstBadVersion(1))
    }

    @Test
    fun largeRange() {
        assertEquals(1_000_000_000, solution(1_000_000_000).firstBadVersion(2_000_000_000))
    }
}
