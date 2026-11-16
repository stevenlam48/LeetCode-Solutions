package directionassignmentswithexactlykvisiblepeople

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DirectionAssignmentsWithExactlyKVisiblePeopleTest {
    @Test
    fun testExample1() {
        assertEquals(2, Solution().countVisiblePeople(3, 1, 2))
    }

    @Test
    fun testExample2() {
        assertEquals(12, Solution().countVisiblePeople(5, 0, 2))
    }

    @Test
    fun testSinglePerson() {
        assertEquals(2, Solution().countVisiblePeople(1, 0, 0))
    }

    @Test
    fun testKEqualsNMinusOne() {
        assertEquals(2, Solution().countVisiblePeople(4, 2, 3))
    }

    @Test
    fun testKZero() {
        assertEquals(2, Solution().countVisiblePeople(4, 2, 0))
    }
}
