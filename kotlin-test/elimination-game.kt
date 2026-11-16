package eliminationgame

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EliminationGameTest {
    @Test
    fun singleElement() {
        assertEquals(1, Solution().lastRemaining(1))
    }

    @Test
    fun twoElements() {
        assertEquals(2, Solution().lastRemaining(2))
    }

    @Test
    fun standardExample() {
        assertEquals(6, Solution().lastRemaining(9))
    }

    @Test
    fun alternatingPasses() {
        assertEquals(8, Solution().lastRemaining(10))
    }
}
