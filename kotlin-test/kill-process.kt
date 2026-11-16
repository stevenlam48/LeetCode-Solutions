package killprocess

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KillProcessTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(
            listOf(5, 10),
            solution.killProcess(intArrayOf(1, 3, 10, 5), intArrayOf(3, 0, 5, 3), 5)
        )
    }

    @Test
    fun singleProcess() {
        assertEquals(listOf(1), solution.killProcess(intArrayOf(1), intArrayOf(0), 1))
    }

    @Test
    fun chain() {
        assertEquals(
            listOf(1, 2, 3),
            solution.killProcess(intArrayOf(1, 2, 3), intArrayOf(0, 1, 2), 1)
        )
    }

    @Test
    fun leafProcess() {
        assertEquals(
            listOf(2),
            solution.killProcess(intArrayOf(1, 2, 3), intArrayOf(0, 0, 0), 2)
        )
    }

    @Test
    fun multipleChildren() {
        assertEquals(
            listOf(1, 2, 3),
            solution.killProcess(intArrayOf(1, 2, 3), intArrayOf(0, 1, 1), 1).sorted()
        )
    }

    @Test
    fun killRoot() {
        assertEquals(
            listOf(1, 2, 3, 4),
            solution.killProcess(intArrayOf(1, 2, 3, 4), intArrayOf(0, 1, 1, 2), 1).sorted()
        )
    }
}
