package racecar

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RaceCarTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(2, solution.racecar(3))
    }

    @Test
    fun testExample2() {
        assertEquals(5, solution.racecar(6))
    }

    @Test
    fun testOne() {
        assertEquals(1, solution.racecar(1))
    }

    @Test
    fun testTwo() {
        assertEquals(4, solution.racecar(2))
    }

    @Test
    fun testFour() {
        assertEquals(5, solution.racecar(4))
    }

    @Test
    fun testFive() {
        assertEquals(7, solution.racecar(5))
    }
}
