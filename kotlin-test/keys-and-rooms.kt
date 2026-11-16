package keysandrooms

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class KeysAndRoomsTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertTrue(solution.canVisitAllRooms(listOf(listOf(1), listOf(2), listOf(3), listOf())))
    }

    @Test
    fun example2() {
        assertFalse(
            solution.canVisitAllRooms(
                listOf(listOf(1, 3), listOf(3, 0, 1), listOf(2), listOf(0))
            )
        )
    }

    @Test
    fun singleRoom() {
        assertTrue(solution.canVisitAllRooms(listOf(listOf(0))))
    }

    @Test
    fun reachableChain() {
        assertTrue(solution.canVisitAllRooms(listOf(listOf(2), listOf(), listOf(1))))
    }

    @Test
    fun unreachableRoom() {
        assertFalse(solution.canVisitAllRooms(listOf(listOf(1), listOf(), listOf(0, 1))))
    }

    @Test
    fun allKeysInFirstRoom() {
        assertTrue(solution.canVisitAllRooms(listOf(listOf(1, 2), listOf(), listOf())))
    }
}
