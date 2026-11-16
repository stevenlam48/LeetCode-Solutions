package permuteUnique

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PermuteUniqueTest {
    private fun normalized(values: List<List<Int>>): Set<List<Int>> = values.toSet()

    @Test
    fun duplicateValues() {
        assertEquals(
            setOf(listOf(1, 1, 2), listOf(1, 2, 1), listOf(2, 1, 1)),
            normalized(Solution().permuteUnique(intArrayOf(1, 1, 2)))
        )
    }

    @Test
    fun distinctValues() {
        val result = Solution().permuteUnique(intArrayOf(3, 1, 2))
        assertEquals(6, result.size)
        assertEquals(6, result.toSet().size)
    }

    @Test
    fun allValuesIdentical() {
        assertEquals(listOf(listOf(2, 2, 2)), Solution().permuteUnique(intArrayOf(2, 2, 2)))
    }

    @Test
    fun emptyInput() {
        assertEquals(listOf(emptyList<Int>()), Solution().permuteUnique(IntArray(0)))
    }
}
