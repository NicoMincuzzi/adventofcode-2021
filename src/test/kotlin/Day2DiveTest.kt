import com.github.nicomincuzzi.Day2Dive
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day2DiveTest {
    @Test
    fun checkFinalHorizontalPositionAndDepth() {
        val measurement = listOf(
            Pair("forward", 5),
            Pair("down", 5),
            Pair("forward", 8),
            Pair("up", 3),
            Pair("down", 8),
            Pair("forward", 2)
        )
        val result = Day2Dive().horizontalPositionAndDepth(measurement)
        Assertions.assertEquals(150, result)
    }

    @Test
    fun checkFinalHorizontalPositionAndDepth_Answer() {
        val measurement = retrieveInput()

        val result = Day2Dive().horizontalPositionAndDepth(measurement)
        Assertions.assertEquals(1692075, result)
    }

    @Test
    fun checkFinalHorizontalPositionAndDepthTwoPart() {
        val measurement = listOf(
            Pair("forward", 5),
            Pair("down", 5),
            Pair("forward", 8),
            Pair("up", 3),
            Pair("down", 8),
            Pair("forward", 2)
        )
        val result = Day2Dive().horizontalPositionAndDepthPartTwo(measurement)
        Assertions.assertEquals(900, result)
    }

    @Test
    fun checkFinalHorizontalPositionAndDepthTwoPart_Answer() {
        val measurement = retrieveInput()

        val result = Day2Dive().horizontalPositionAndDepthPartTwo(measurement)
        Assertions.assertEquals(1749524700, result)
    }

    private fun retrieveInput(): List<Pair<String, Int>> {
        val rows = Day1SonarSweepTest::class.java.getResource("/day2.txt").readText()
        val commands = rows.split("\n").filter { x -> x.isNotBlank() }
        return commands.mapTo(mutableListOf()) { x -> Pair(x.split(" ")[0], (x.split(" ")[1]).toInt()) }
    }
}