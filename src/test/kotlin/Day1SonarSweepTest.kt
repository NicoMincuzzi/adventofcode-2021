import com.github.nicomincuzzi.Day1SonarSweep
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day1SonarSweepTest {

    @Test
    fun checkNumberOfTimesDepthMeasurementIncreases() {
        val measurement = listOf(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)
        val result = Day1SonarSweep().sonarSweep(measurement)
        assertEquals(7, result)
    }

    @Test
    fun checkNumberOfTimesDepthMeasurementIncreases_Answer() {
        val measurement = retrieveInput()

        val result = Day1SonarSweep().sonarSweep(measurement)
        assertEquals(1301, result)
    }

    @Test
    fun checkNumberOfTimesDepthMeasurementIncreasesPartTwo() {
        val measurement = listOf(607, 618, 618, 617, 647, 716, 769, 792)
        val result = Day1SonarSweep().sonarSweepPartTwo(measurement)
        assertEquals(5, result)
    }

    @Test
    fun checkNumberOfTimesDepthMeasurementIncreasesPartTwo_Answer() {
        val measurement = retrieveInput()

        val result = Day1SonarSweep().sonarSweepPartTwo(measurement)
        assertEquals(1346, result)
    }

    private fun retrieveInput(): List<Int> {
        val rows = Day1SonarSweepTest::class.java.getResource("/day1.txt").readText()
        return rows.split("\n").filter { x -> x.isNotBlank() }.map(String::toInt)
    }
}