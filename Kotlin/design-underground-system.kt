package designundergroundsystem

// Time:  ctor:       O(1)
//        checkin:    O(1)
//        checkout:   O(1)
//        getaverage: O(1)
// Space: O(n)

class UndergroundSystem {
    private val live = HashMap<Int, Pair<String, Int>>()
    private val statistics = HashMap<String, HashMap<String, Pair<Int, Int>>>()

    fun checkIn(id: Int, stationName: String, t: Int) {
        live[id] = Pair(stationName, t)
    }

    fun checkOut(id: Int, stationName: String, t: Int) {
        val (startStation, startTime) = live[id]!!
        live.remove(id)
        val stats = statistics.getOrPut(startStation) { HashMap() }
        val (totalTime, cnt) = stats.getOrDefault(stationName, Pair(0, 0))
        stats[stationName] = Pair(totalTime + t - startTime, cnt + 1)
    }

    fun getAverageTime(startStation: String, endStation: String): Double {
        val (totalTime, cnt) = statistics[startStation]!![endStation]!!
        return totalTime.toDouble() / cnt
    }
}
