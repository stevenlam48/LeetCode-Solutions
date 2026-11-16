package fibonaccinumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FibonacciNumberTest {
    @Test
    fun baseCases() {
        assertEquals(0, Solution().fib(0))
        assertEquals(1, Solution().fib(1))
    }

    @Test
    fun firstNontrivialValues() {
        assertEquals(1, Solution().fib(2))
        assertEquals(2, Solution().fib(3))
        assertEquals(3, Solution().fib(4))
    }

    @Test
    fun tenthFibonacciNumber() {
        assertEquals(55, Solution().fib(10))
    }

    @Test
    fun thirtiethFibonacciNumber() {
        assertEquals(832040, Solution().fib(30))
    }
}
