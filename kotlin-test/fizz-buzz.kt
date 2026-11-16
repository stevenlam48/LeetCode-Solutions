package fizzbuzz

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FizzBuzzTest {
    @Test
    fun three() {
        assertEquals(listOf("1", "2", "Fizz"), Solution().fizzBuzz(3))
    }

    @Test
    fun five() {
        assertEquals(listOf("1", "2", "Fizz", "4", "Buzz"), Solution().fizzBuzz(5))
    }

    @Test
    fun fifteen() {
        val result = Solution().fizzBuzz(15)
        assertEquals(15, result.size)
        assertEquals("FizzBuzz", result[14])
        assertEquals("Fizz", result[2])
        assertEquals("Buzz", result[4])
        assertEquals("11", result[10])
    }

    @Test
    fun zero() {
        assertEquals(emptyList<String>(), Solution().fizzBuzz(0))
    }
}
