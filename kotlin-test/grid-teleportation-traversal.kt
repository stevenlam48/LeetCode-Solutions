package gridteleportationtraversal

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GridTeleportationTraversalTest {
    @Test
    fun singleCell() {
        assertEquals(0, Solution().minMoves(listOf(".")))
    }

    @Test
    fun singleRow() {
        assertEquals(2, Solution().minMoves(listOf("...")))
    }

    @Test
    fun obstacles() {
        assertEquals(-1, Solution().minMoves(listOf("..#", "#..", "..#")))
    }

    @Test
    fun longerPath() {
        assertEquals(4, Solution().minMoves(listOf(".#.", ".#.", "...")))
    }

    @Test
    fun teleportSavesMoves() {
        assertEquals(1, Solution().minMoves(listOf("A.A", "...")))
    }

    @Test
    fun teleportToTarget() {
        assertEquals(0, Solution().minMoves(listOf("A..A")))
    }
}
