package buildanarraywithstackoperations

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BuildAnArrayWithStackOperationsTest {
    @Test
    fun example1() {
        assertEquals(
            listOf("Push", "Push", "Pop", "Push"),
            Solution().buildArray(intArrayOf(1, 3), 3)
        )
    }

    @Test
    fun example2() {
        assertEquals(
            listOf("Push", "Push", "Push"),
            Solution().buildArray(intArrayOf(1, 2, 3), 3)
        )
    }

    @Test
    fun example3() {
        assertEquals(
            listOf("Push", "Push"),
            Solution().buildArray(intArrayOf(1, 2), 4)
        )
    }

    @Test
    fun skipFirst() {
        assertEquals(
            listOf("Push", "Pop", "Push", "Push", "Push"),
            Solution().buildArray(intArrayOf(2, 3, 4), 4)
        )
    }
}
