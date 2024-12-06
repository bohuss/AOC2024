class Day3 {
    val testAnswer1 = "161"
    fun part1(input: List<String>): String {
        var ans = 0L
        for(s in input) {
            s.indices.map { i ->
                getCommand(s, i)
            }.forEach {
                if(it is MulCommand) {
                    ans += it.getResult()
                }
            }
        }
        return "$ans"
    }

    val testAnswer2 = "48"
    fun part2(input: List<String>): String {
        var ans = 0L
        var ok = true
        for(s in input) {
            s.indices.map { i ->
                getCommand(s, i)
            }.forEach {
                when(it) {
                    is MulCommand -> {
                        if(ok)ans += it.getResult()
                    }
                    is DoCommand -> {
                        ok = true
                    }
                    is DontCommand -> {
                        ok = false
                    }
                }
            }
        }
        return "$ans"
    }

    private fun getCommand(s: String, start: Int): Command? {

        if (start + 4 <= s.length && s.substring(start, start + 4) == "do()") {
            return DoCommand()
        }

        if (start + 7 <= s.length && s.substring(start, start + 7) == "don't()") {
            return DontCommand()
        }

        val r1 = "^mul\\((?<a>[0-9]{1,3}),(?<b>[0-9]{1,3})\\)".toRegex()

        return r1.find(s.substring(start))
            ?.let{
                val b = it.groups["a"]?.value!!.toInt()
                val c = it.groups["b"]?.value!!.toInt()
                return MulCommand(b, c)
            }
    }

    open class Command

    class MulCommand(val a: Int, val b: Int): Command() {
        fun getResult() = a * b
    }

    class DoCommand: Command()

    class DontCommand: Command()

}
