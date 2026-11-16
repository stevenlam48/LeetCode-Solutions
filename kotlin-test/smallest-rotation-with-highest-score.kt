package smallestrotationwithhighestscore

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SmallestRotationWithHighestScoreTest {
    private val solution = Solution()

    @Test
    fun examples() {
        assertEquals(3, solution.bestRotation(intArrayOf(2, 3, 1, 4, 0)))
        assertEquals(0, solution.bestRotation(intArrayOf(1, 3, 0, 2, 4)))
    }

    @Test
    fun singleElement() {
        assertEquals(0, solution.bestRotation(intArrayOf(0)))
        assertEquals(0, solution.bestRotation(intArrayOf(1)))
    }

    @Test
    fun tiesChooseSmallestRotation() {
        assertEquals(0, solution.bestRotation(intArrayOf(0, 0, 0)))
        assertEquals(0, solution.bestRotation(intArrayOf(0, 2, 1)))
    }
}
