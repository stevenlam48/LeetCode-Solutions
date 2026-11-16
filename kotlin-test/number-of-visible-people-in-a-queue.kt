package numberofvisiblepeopleinaqueue

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class NumberOfVisiblePeopleInAQueueTest {
    @Test
    fun example1() {
        assertArrayEquals(intArrayOf(3, 1, 2, 1, 1, 0), Solution().canSeePersonsCount(intArrayOf(10, 6, 8, 5, 11, 9)))
    }

    @Test
    fun example2() {
        assertArrayEquals(intArrayOf(4, 1, 1, 1, 0), Solution().canSeePersonsCount(intArrayOf(5, 1, 2, 3, 10)))
    }

    @Test
    fun single() {
        assertArrayEquals(intArrayOf(0), Solution().canSeePersonsCount(intArrayOf(1)))
    }

    @Test
    fun twoEqual() {
        assertArrayEquals(intArrayOf(1, 0), Solution().canSeePersonsCount(intArrayOf(1, 1)))
    }
}
