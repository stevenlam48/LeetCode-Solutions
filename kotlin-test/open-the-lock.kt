package openthelock

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class OpenTheLockTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(
            6,
            solution.openLock(listOf("0201", "0101", "0102", "1212", "2002"), "0202")
        )
    }

    @Test
    fun testExample2() {
        assertEquals(1, solution.openLock(listOf("8888"), "0009"))
    }

    @Test
    fun testBlocked() {
        assertEquals(
            -1,
            solution.openLock(
                listOf("8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"),
                "8888"
            )
        )
    }

    @Test
    fun testAlreadyOpen() {
        assertEquals(0, solution.openLock(emptyList(), "0000"))
    }
}
