package removeboxes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveBoxesTest {
    @Test
    fun standardExample() {
        assertEquals(23, Solution().removeBoxes(intArrayOf(1, 3, 2, 2, 2, 3, 4, 3, 1)))
    }

    @Test
    fun allBoxesHaveSameColor() {
        assertEquals(9, Solution().removeBoxes(intArrayOf(1, 1, 1)))
    }

    @Test
    fun singleBox() {
        assertEquals(1, Solution().removeBoxes(intArrayOf(1)))
    }

    @Test
    fun separatedMatchingBoxes() {
        assertEquals(5, Solution().removeBoxes(intArrayOf(1, 2, 1)))
        assertEquals(2, Solution().removeBoxes(intArrayOf(1, 2)))
    }
}
