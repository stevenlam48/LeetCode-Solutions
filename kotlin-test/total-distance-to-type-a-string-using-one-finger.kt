package totaldistancetotypeastringusingonefinger

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TotalDistanceToTypeAStringUsingOneFingerTest {
    @Test
    fun topRow() {
        assertEquals(10, Solution().totalDistance("qwertyuiop"))
    }

    @Test
    fun repeatedFirstKey() {
        assertEquals(0, Solution().totalDistance("aaa"))
    }

    @Test
    fun emptyString() {
        assertEquals(0, Solution().totalDistance(""))
    }

    @Test
    fun crossesRows() {
        assertEquals(5, Solution().totalDistance("ab"))
    }

    @Test
    fun hello() {
        assertEquals(17, Solution().totalDistance("hello"))
    }
}
