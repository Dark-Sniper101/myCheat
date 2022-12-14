package me.grison.aoc.y2021

import me.grison.aoc.Day
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

data class Answer(val inst: () -> Day, val part1: Any, val part2: Any)

class AllDaysTest {
    @TestFactory
    fun answers() = listOf(
        Answer({ Day01() }, 1581, 1618),
        Answer({ Day02() }, 2117664, 2073416724),
        Answer({ Day03() }, 1082324, 1353024),
        Answer({ Day04() }, 58374, 11377),
        Answer({ Day05() }, 6113, 20373),
        Answer({ Day06() }, 351188, 1595779846729),
        Answer({ Day07() }, 341534, 93397707),
        Answer({ Day08() }, 539, 1084606),
        Answer({ Day09() }, 537, 1142757),
        Answer({ Day10() }, 367227, 3583341858),
        Answer({ Day11() }, 1661, 434),
        Answer({ Day12() }, 4749, 123054),
        Answer({ Day13() }, 602, "CAFJHZCK"),
        Answer({ Day14() }, 2549, 2516901104210),
        Answer({ Day15() }, 523, 2876),
        Answer({ Day16() }, 1014, 1922490999789),
        Answer({ Day17() }, 23005, 2040),
        Answer({ Day18() }, 3816, 4819),
        Answer({ Day19() }, 479, 13113),
        Answer({ Day20() }, 4928, 16605),
        Answer({ Day21() }, 913560, 110271560863819),
        Answer({ Day22() }, 581108, 1325473814582641),
        Answer({ Day23() }, 19019, 47533),
        Answer({ Day24() }, 99691891979938, 27141191213911),
        Answer({ Day25() }, 305, "Merry Christmas!"),
    ).map {
        val day = it.inst.invoke()
        DynamicTest.dynamicTest("Day ${day.year}/${day.dayNumber} - Part 1 - expecting ${it.part1}") {
            assertThat(day.partOne(), `is`(it.part1))
        }
        DynamicTest.dynamicTest("Day ${day.year}/${day.dayNumber} - Part 2 - expecting ${it.part2}") {
            assertThat(
                if (day.dayNumber < 25) day.partTwo()
                else "Merry Christmas!", `is`(it.part2)
            )
        }
    }
}
