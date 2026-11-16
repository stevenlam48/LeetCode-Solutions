package examroom

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ExamRoomTest {
    @Test
    fun testExampleSequence() {
        val room = ExamRoom(10)
        assertEquals(0, room.seat())
        assertEquals(9, room.seat())
        assertEquals(4, room.seat())
        assertEquals(2, room.seat())
        room.leave(4)
        assertEquals(5, room.seat())
    }

    @Test
    fun testSingleSeat() {
        val room = ExamRoom(1)
        assertEquals(0, room.seat())
        room.leave(0)
        assertEquals(0, room.seat())
    }

    @Test
    fun testTwoSeats() {
        val room = ExamRoom(2)
        assertEquals(0, room.seat())
        assertEquals(1, room.seat())
        room.leave(0)
        assertEquals(0, room.seat())
    }

    @Test
    fun testLeaveAndReseat() {
        val room = ExamRoom(5)
        assertEquals(0, room.seat())
        assertEquals(4, room.seat())
        assertEquals(2, room.seat())
        room.leave(2)
        assertEquals(2, room.seat())
    }

    @Test
    fun testFillAllSeats() {
        val room = ExamRoom(4)
        val seated = sortedSetOf<Int>()
        repeat(4) { seated.add(room.seat()) }
        assertEquals(setOf(0, 1, 2, 3), seated)
    }
}
