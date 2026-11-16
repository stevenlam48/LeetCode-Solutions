package rewardtopkstudents

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class RewardTopKStudentsTest {
    @Test
    fun exampleOne() {
        assertArrayEquals(intArrayOf(1, 2), Solution().topStudents(
            listOf("smart", "brilliant", "studious"),
            listOf("not"),
            listOf("this student is studious", "the student is smart"),
            intArrayOf(1, 2), 2
        ))
    }

    @Test
    fun exampleTwo() {
        assertArrayEquals(intArrayOf(2, 1), Solution().topStudents(
            listOf("smart", "brilliant", "studious"),
            listOf("not"),
            listOf("this student is not studious", "the student is smart"),
            intArrayOf(1, 2), 2
        ))
    }

    @Test
    fun scoreTiesUseStudentId() {
        assertArrayEquals(intArrayOf(1, 2, 3), Solution().topStudents(
            listOf("good"), listOf("bad"),
            listOf("good", "unknown", "good"),
            intArrayOf(2, 3, 1), 3
        ))
    }

    @Test
    fun kIsZero() {
        assertArrayEquals(intArrayOf(), Solution().topStudents(listOf("good"), listOf(), listOf("good"), intArrayOf(1), 0))
    }
}
