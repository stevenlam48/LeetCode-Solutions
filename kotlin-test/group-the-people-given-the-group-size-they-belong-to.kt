package groupthepeoplegiventhegroupsizetheybelongto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GroupThePeopleGivenTheGroupSizeTheyBelongToTest {
    private fun normalize(groups: List<List<Int>>): List<List<Int>> = groups.sortedBy { it.joinToString(",") }

    @Test
    fun example1() {
        val groupSizes = intArrayOf(3, 3, 3, 3, 3, 1, 3)
        val expected = listOf(listOf(5), listOf(0, 1, 2), listOf(3, 4, 6))
        assertEquals(normalize(expected), normalize(Solution().groupThePeople(groupSizes)))
    }

    @Test
    fun example2() {
        val groupSizes = intArrayOf(2, 1, 3, 3, 3, 2)
        val expected = listOf(listOf(1), listOf(0, 5), listOf(2, 3, 4))
        assertEquals(normalize(expected), normalize(Solution().groupThePeople(groupSizes)))
    }

    @Test
    fun singlePerson() {
        assertEquals(listOf(listOf(0)), Solution().groupThePeople(intArrayOf(1)))
    }

    @Test
    fun everyoneAlone() {
        val expected = listOf(listOf(0), listOf(1), listOf(2))
        assertEquals(normalize(expected), normalize(Solution().groupThePeople(intArrayOf(1, 1, 1))))
    }

    @Test
    fun sameSizeTwoGroups() {
        val expected = listOf(listOf(0, 1), listOf(2, 3))
        assertEquals(normalize(expected), normalize(Solution().groupThePeople(intArrayOf(2, 2, 2, 2))))
    }
}
