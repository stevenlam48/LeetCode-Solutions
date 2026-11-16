package smallestsubarrayswithmaximumbitwiseor

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SmallestSubarraysWithMaximumBitwiseOrTest {
    private val solution = Solution()

    @Test
    fun examples() {
        assertArrayEquals(intArrayOf(3, 3, 2, 2, 1), solution.smallestSubarrays(intArrayOf(1, 0, 2, 1, 3)))
        assertArrayEquals(intArrayOf(2, 1), solution.smallestSubarrays(intArrayOf(1, 2)))
    }

    @Test
    fun zeros() {
        assertArrayEquals(intArrayOf(1), solution.smallestSubarrays(intArrayOf(0)))
        assertArrayEquals(intArrayOf(1, 1), solution.smallestSubarrays(intArrayOf(0, 0)))
    }

    @Test
    fun highBits() {
        assertArrayEquals(intArrayOf(3, 2, 1), solution.smallestSubarrays(intArrayOf(1, 2, 4)))
    }
}
