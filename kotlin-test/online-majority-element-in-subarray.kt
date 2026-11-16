package onlinemajorityelementinsubarray

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class OnlineMajorityElementInSubarrayTest {
    @Test
    fun testExample() {
        val checker = MajorityChecker(intArrayOf(1, 1, 2, 2, 1, 1))
        assertEquals(1, checker.query(0, 5, 4))
        assertEquals(-1, checker.query(0, 3, 3))
        assertEquals(2, checker.query(2, 3, 2))
    }

    @Test
    fun testSingleElement() {
        val checker = MajorityChecker(intArrayOf(5))
        assertEquals(5, checker.query(0, 0, 1))
        assertEquals(-1, checker.query(0, 0, 2))
    }

    @Test
    fun testNoMajority() {
        val checker = MajorityChecker(intArrayOf(1, 2, 3, 4, 5))
        assertEquals(-1, checker.query(0, 4, 2))
    }
}
