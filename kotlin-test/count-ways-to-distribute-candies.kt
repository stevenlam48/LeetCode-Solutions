package countwaystodistributecandies

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountWaysToDistributeCandiesTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().waysToDistribute(3, 2))
    }

    @Test
    fun example2() {
        assertEquals(1, Solution().waysToDistribute(2, 2))
    }

    @Test
    fun example3() {
        assertEquals(25, Solution().waysToDistribute(5, 3))
    }

    @Test
    fun oneBag() {
        assertEquals(1, Solution().waysToDistribute(1, 1))
        assertEquals(1, Solution().waysToDistribute(5, 1))
    }

    @Test
    fun twoBags() {
        assertEquals(7, Solution().waysToDistribute(4, 2))
    }
}
