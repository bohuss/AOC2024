import kotlin.math.absoluteValue

class Day1 {
    val testAnswer1 = "11"
    fun part1(input: List<String>): String {
        var ans = 0L

        val c = ArrayList<Int>()
        val d = ArrayList<Int>()
        for(s in input) {
            val a = s.split("[, ]+".toRegex()).map { it.toInt() }
            c.add(a[0])
            d.add(a[1])
        }
        c.sort()
        d.sort()
        for(i in 0 until c.size){
            ans += (d[i] - c[i]).absoluteValue
        }
        return "$ans"
    }


    val testAnswer2 = "31"
    fun part2(input: List<String>): String {
        var ans = 0L
        val c = ArrayList<Int>()
        val d = ArrayList<Int>()
        for(s in input) {
            val a = s.split("[, ]+".toRegex()).map { it.toInt() }
            c.add(a[0])
            d.add(a[1])
        }

        val x = d.groupingBy { it }.eachCount()

        for(i in 0 until c.size){
            ans += (x[c[i]] ?: 0) * c[i]
        }
        return "$ans"
    }


}
