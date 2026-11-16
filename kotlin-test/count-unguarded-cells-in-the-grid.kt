package countunguardedcellsinthegrid

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountUnguardedCellsInTheGridTest {
    @Test
    fun firstExample() {
        assertEquals(
            7,
            Solution().countUnguarded(
                4,
                6,
                arrayOf(intArrayOf(0, 0), intArrayOf(1, 1), intArrayOf(2, 3)),
                arrayOf(intArrayOf(0, 1), intArrayOf(2, 2), intArrayOf(1, 4))
            )
        )
    }

    @Test
    fun wallsEncloseGuard() {
        assertEquals(
            4,
            Solution().countUnguarded(
                3,
                3,
                arrayOf(intArrayOf(1, 1)),
                arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(2, 1), intArrayOf(1, 2))
            )
        )
    }

    @Test
    fun noGuardsOrWalls() {
        assertEquals(6, Solution().countUnguarded(2, 3, arrayOf(), arrayOf()))
    }

    @Test
    fun singleCellOccupiedByGuard() {
        assertEquals(
            0,
            Solution().countUnguarded(1, 1, arrayOf(intArrayOf(0, 0)), arrayOf())
        )
    }
}
