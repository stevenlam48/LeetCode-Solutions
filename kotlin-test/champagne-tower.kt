package champagnetower

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ChampagneTowerTest {
    private val solution = Solution()

    @Test
    fun singleGlassFull() {
        assertEquals(1.0, solution.champagneTower(1, 0, 0), 1e-9)
    }

    @Test
    fun singleGlassEmpty() {
        assertEquals(0.0, solution.champagneTower(0, 0, 0), 1e-9)
    }

    @Test
    fun secondRowExamples() {
        assertEquals(0.0, solution.champagneTower(1, 1, 1), 1e-9)
        assertEquals(0.5, solution.champagneTower(2, 1, 1), 1e-9)
    }

    @Test
    fun largePourCapsGlass() {
        assertEquals(1.0, solution.champagneTower(100000009, 33, 17), 1e-9)
    }
}
