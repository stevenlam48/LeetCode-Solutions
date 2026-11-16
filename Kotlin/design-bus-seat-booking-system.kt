package designbusseatbookingsystem

// Time:  ctor:         O(1)
//        toggle:       O(1)
//        getTotalTime: O(1)
//        getMinTime:   O(1)
// Space: O(n)
class BusBooking(n: Int) {
    private var total = 0
    private val lookup = HashMap<String, Int>()

    fun toggle(seat: String) {
        lookup.remove(seat)?.let {
            total -= it
            return
        }
        val value = if ((seat[0] == 'A' && lookup.containsKey("B" + seat.substring(1))) ||
            (seat[0] == 'D' && lookup.containsKey("C" + seat.substring(1)))) 3 else 1
        lookup[seat] = value
        total += value
    }

    fun getTotalTime(): Int = total

    fun getMinTime(): Int = lookup.size
}
