import com.github.nicomincuzzi.Day3BinaryDiagnostic
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day3BinaryDiagnosticTest {

    @Test
    fun checkNumberOfTimesDepthMeasurementIncreases() {
        val diagnosticReport = listOf(
            "00100",
            "11110",
            "10110",
            "10111",
            "10101",
            "01111",
            "00111",
            "11100",
            "10000",
            "11001",
            "00010",
            "01010"
        )
        val result = Day3BinaryDiagnostic().diagnostic(diagnosticReport)
        Assertions.assertEquals(198, result)
    }

    @Test
    fun checkNumberOfTimesDepthMeasurementIncreases_Answer() {
        val diagnosticReport = retrieveInput()

        val result = Day3BinaryDiagnostic().diagnostic(diagnosticReport)
        Assertions.assertEquals(3277364, result)
    }

    @Test
    fun checkNumberOfTimesDepthMeasurementIncreases_PartTwo() {
        val diagnosticReport = listOf(
            "00100",
            "11110",
            "10110",
            "10111",
            "10101",
            "01111",
            "00111",
            "11100",
            "10000",
            "11001",
            "00010",
            "01010"
        )
        val result = Day3BinaryDiagnostic().diagnosticPartTwo(diagnosticReport)
        Assertions.assertEquals(230, result)
    }

    @Test
    fun checkNumberOfTimesDepthMeasurementIncreases_Answer_PartTwo() {
        val diagnosticReport = retrieveInput()

        val result = Day3BinaryDiagnostic().diagnosticPartTwo(diagnosticReport)
        Assertions.assertEquals(5736383, result)
    }

    private fun retrieveInput(): List<String> {
        val rows = Day1SonarSweepTest::class.java.getResource("/day3.txt").readText()
        return rows.split("\n").filter { x -> x.isNotBlank() }
    }
}