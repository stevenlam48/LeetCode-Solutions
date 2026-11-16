package findallpeoplewithsecret

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindAllPeopleWithSecretTest {
    @Test
    fun firstLeetCodeExample() {
        val meetings = arrayOf(intArrayOf(1, 2, 5), intArrayOf(2, 3, 8), intArrayOf(1, 5, 10))
        assertEquals(listOf(0, 1, 2, 3, 5), Solution().findAllPeople(6, meetings, 1).sorted())
    }

    @Test
    fun secondLeetCodeExample() {
        val meetings = arrayOf(intArrayOf(3, 1, 3), intArrayOf(1, 2, 2), intArrayOf(0, 3, 3))
        assertEquals(listOf(0, 1, 3), Solution().findAllPeople(4, meetings, 3).sorted())
    }

    @Test
    fun allMeetingsAtSameTimePropagateAcrossComponents() {
        val meetings = arrayOf(intArrayOf(1, 2, 1), intArrayOf(2, 3, 1), intArrayOf(3, 4, 2))
        assertEquals(listOf(0, 1, 2, 3, 4), Solution().findAllPeople(5, meetings, 1).sorted())
    }

    @Test
    fun noMeetings() {
        assertEquals(listOf(0, 2), Solution().findAllPeople(4, emptyArray(), 2).sorted())
    }
}
