package minimumadjacentswapstoreachthekthsmallestnumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumAdjacentSwapsToReachTheKthSmallestNumberTest {
    @Test
    fun fourthPermutation() = assertEquals(2, Solution().getMinSwaps("5489355142", 4))

    @Test
    fun repeatedDigits() = assertEquals(4, Solution().getMinSwaps("11112", 4))

    @Test
    fun leadingZero() = assertEquals(1, Solution().getMinSwaps("00123", 1))

    @Test
    fun alreadyAtRequestedPermutation() = assertEquals(0, Solution().getMinSwaps("1234", 0))
}
