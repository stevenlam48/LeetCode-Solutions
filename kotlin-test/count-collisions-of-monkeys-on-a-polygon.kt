package countcollisionsofmonkeysonapolygon

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountCollisionsOfMonkeysOnAPolygonTest {
    @Test
    fun smallPolygons() {
        assertEquals(0, Solution().monkeyMove(1))
        assertEquals(2, Solution().monkeyMove(2))
        assertEquals(6, Solution().monkeyMove(3))
    }

    @Test
    fun largerPolygon() {
        assertEquals(14, Solution().monkeyMove(4))
        assertEquals(1022, Solution().monkeyMove(10))
    }

    @Test
    fun moduloResult() {
        assertEquals(254, Solution().monkeyMove(8))
    }
}
