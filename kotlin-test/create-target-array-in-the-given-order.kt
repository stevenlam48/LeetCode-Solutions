package createtargetarrayinthegivenorder

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class CreateTargetArrayInTheGivenOrderTest {
    @Test
    fun `shifts values when target indices collide`() {
        val result = Solution().createTargetArray(
            intArrayOf(0, 1, 2, 3, 4), intArrayOf(0, 1, 2, 2, 1)
        )
        assertArrayEquals(intArrayOf(0, 4, 1, 3, 2), result)
    }

    @Test
    fun `inserting zero at the beginning shifts every value`() {
        val result = Solution().createTargetArray(
            intArrayOf(1, 2, 3, 4, 0), intArrayOf(0, 1, 2, 3, 0)
        )
        assertArrayEquals(intArrayOf(0, 1, 2, 3, 4), result)
    }

    @Test
    fun `handles one value`() {
        assertArrayEquals(intArrayOf(7), Solution().createTargetArray(intArrayOf(7), intArrayOf(0)))
    }

    @Test
    fun `handles empty arrays`() {
        assertArrayEquals(intArrayOf(), Solution().createTargetArray(intArrayOf(), intArrayOf()))
    }
}
