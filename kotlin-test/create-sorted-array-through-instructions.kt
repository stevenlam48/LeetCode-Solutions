package createsortedarraythroughinstructions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CreateSortedArrayThroughInstructionsTest {
    @Test
    fun `counts one cheaper insertion`() {
        assertEquals(1, Solution().createSortedArray(intArrayOf(1, 5, 6, 2)))
    }

    @Test
    fun `counts costs with duplicate values`() {
        assertEquals(1, Solution().createSortedArray(intArrayOf(1, 2, 3, 6, 5, 6)))
    }

    @Test
    fun `accumulates both smaller and larger insertion costs`() {
        val instructions = intArrayOf(1, 3, 3, 3, 2, 4, 2, 1, 2)
        assertEquals(4, Solution().createSortedArray(instructions))
    }

    @Test
    fun `a single insertion has zero cost`() {
        assertEquals(0, Solution().createSortedArray(intArrayOf(1)))
    }
}
