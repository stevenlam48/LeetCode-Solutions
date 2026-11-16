package lexicographicalnumbers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LexicographicalNumbersTest {
    @Test
    fun example1() {
        assertEquals(
            listOf(1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9),
            Solution().lexicalOrder(13)
        )
    }

    @Test
    fun two() {
        assertEquals(listOf(1, 2), Solution().lexicalOrder(2))
    }

    @Test
    fun ten() {
        assertEquals(listOf(1, 10, 2, 3, 4, 5, 6, 7, 8, 9), Solution().lexicalOrder(10))
    }

    @Test
    fun one() {
        assertEquals(listOf(1), Solution().lexicalOrder(1))
    }
}
