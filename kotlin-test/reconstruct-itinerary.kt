package reconstructitinerary

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ReconstructItineraryTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val tickets = listOf(
            listOf("MUC", "LHR"),
            listOf("JFK", "MUC"),
            listOf("SFO", "SJC"),
            listOf("LHR", "SFO")
        )
        assertEquals(listOf("JFK", "MUC", "LHR", "SFO", "SJC"), solution.findItinerary(tickets))
    }

    @Test
    fun testExample2() {
        val tickets = listOf(
            listOf("JFK", "SFO"),
            listOf("JFK", "ATL"),
            listOf("SFO", "ATL"),
            listOf("ATL", "JFK"),
            listOf("ATL", "SFO")
        )
        assertEquals(listOf("JFK", "ATL", "JFK", "SFO", "ATL", "SFO"), solution.findItinerary(tickets))
    }

    @Test
    fun testSingleTicket() {
        val tickets = listOf(listOf("JFK", "AAA"))
        assertEquals(listOf("JFK", "AAA"), solution.findItinerary(tickets))
    }

    @Test
    fun testLexicalOrderPreference() {
        val tickets = listOf(
            listOf("JFK", "KUL"),
            listOf("JFK", "NRT"),
            listOf("NRT", "JFK")
        )
        assertEquals(listOf("JFK", "NRT", "JFK", "KUL"), solution.findItinerary(tickets))
    }

    @Test
    fun testDuplicateTickets() {
        val tickets = listOf(
            listOf("JFK", "ATL"),
            listOf("ATL", "JFK"),
            listOf("JFK", "ATL")
        )
        assertEquals(listOf("JFK", "ATL", "JFK", "ATL"), solution.findItinerary(tickets))
    }

    @Test
    fun testLongerRoute() {
        val tickets = listOf(
            listOf("JFK", "B"),
            listOf("B", "C"),
            listOf("C", "D"),
            listOf("D", "B"),
            listOf("B", "A")
        )
        assertEquals(listOf("JFK", "B", "C", "D", "B", "A"), solution.findItinerary(tickets))
    }
}
