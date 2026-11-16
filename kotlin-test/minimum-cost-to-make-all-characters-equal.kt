package minimumcosttomakeallcharactersequal

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostToMakeAllCharactersEqualTest {
    private val solution = Solution()

    @Test
    fun allCharactersAlreadyEqual() {
        assertEquals(0L, solution.minimumCost("0000"))
        assertEquals(0L, solution.minimumCost("1"))
    }

    @Test
    fun twoBlocks() {
        assertEquals(2L, solution.minimumCost("0011"))
    }

    @Test
    fun alternatingCharacters() {
        assertEquals(6L, solution.minimumCost("01010"))
    }

    @Test
    fun transitionsHaveDifferentCosts() {
        assertEquals(1L, solution.minimumCost("0001"))
    }
}
