package dividearrayintoequalpairs

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DivideArrayIntoEqualPairsTest {
    private val solution = Solution()

    @Test
    fun evenFrequencies() {
        assertTrue(solution.divideArray(intArrayOf(3, 2, 3, 2, 2, 2)))
    }

    @Test
    fun oddFrequencies() {
        assertFalse(solution.divideArray(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun emptyArray() {
        assertTrue(solution.divideArray(intArrayOf()))
    }

    @Test
    fun negativePairs() {
        assertTrue(solution.divideArray(intArrayOf(-1, -1, 0, 0)))
    }
}
