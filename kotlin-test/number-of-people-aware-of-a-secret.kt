package numberofpeopleawareofasecret

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfPeopleAwareOfASecretTest {
    private val solution = Solution()

    @Test
    fun `counts people after sharing and forgetting`() {
        assertEquals(5, solution.peopleAwareOfSecret(6, 2, 4))
    }

    @Test
    fun `counts people when sharing starts after one day`() {
        assertEquals(6, solution.peopleAwareOfSecret(4, 1, 3))
    }

    @Test
    fun `handles the initial day`() {
        assertEquals(1, solution.peopleAwareOfSecret(1, 2, 4))
    }

    @Test
    fun `handles forgetting immediately after one day of sharing`() {
        assertEquals(2, solution.peopleAwareOfSecret(5, 1, 2))
    }

    @Test
    fun `handles people forgotten before the final day`() {
        assertEquals(1, solution.peopleAwareOfSecret(6, 2, 3))
    }
}
