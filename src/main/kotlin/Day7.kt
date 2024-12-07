import kotlin.math.roundToLong

class Day7 {
    val testAnswer1 = "3749"
    fun part1(input: List<String>): String {
        var ans = 0L

        for(s in input) {
            val a = s.split(": ")
            val x = a[0].toLong()
            val b = a[1].split(" ").map { it.toInt() }
            val n = b.size
            for(i in 0 until (1 shl n - 1)) {
                var sum = b[0].toLong()

                for (j in 0 until n - 1) {
                    if (i and (1 shl j) > 0) {
                        sum += b[j + 1]
                    } else {
                        sum *= b[j + 1]
                    }
                }
                if (sum == x) {
                    ans += x
                    break
                }
            }

        }
        return "$ans"
    }


    val testAnswer2 = "11387"
    fun part2(input: List<String>): String {
        var ans = 0L
        for(s in input) {
            val a = s.split(": ")
            val x = a[0].toLong()
            val b = a[1].split(" ").map { it.toInt() }
            val n = b.size

            val max = Math.pow(3.0, n.toDouble()).roundToLong()
            for(i in 0 until max) {
                var sum = b[0].toLong()
                var now = i
                for (j in 0 until n - 1) {
                    when(now % 3){
                        0L -> sum += b[j + 1]
                        1L -> sum *= b[j + 1]
                        else -> sum = "$sum${b[j + 1]}".toLong()
                    }
                    now /= 3
                }
                if (sum == x) {
                    ans += x
                    break
                }
            }
        }
        return "$ans"
    }


}
