package me.grison.aoc.y2022

import me.grison.aoc.Day
import me.grison.aoc.butLast

class Day02 : Day(2, 2022) {
    override fun title() = "Rock Paper Scissors"

    override fun partOne() = solve()

    override fun partTwo() = solve { round -> round.butLast() + roundEnding[round] }

    private fun solve(inputMixer: (String) -> String = { it }) =
        inputList
            .map { inputMixer(it) }
            .sumOf { outcomes.getValue(it) + shapeScores.getValue(it.last()) }

    // X: ๐ฟ; Y: ๐; Z: โ๏ธ
    private val shapeScores = mapOf('X' to 1, 'Y' to 2, 'Z' to 3).withDefault { 0 }

    private val outcomes = mapOf(
        "A X" to 3 /* ๐ฟ */, "B Y" to 3 /* ๐ */, "C Z" to 3 /* โ๏ธ๏ธ */,         // draw
        "A Y" to 6 /* ๐ฟ ๐ */, "B Z" to 6 /* ๐ โ๏ธ */, "C X" to 6 /* โ๏ธ ๐ฟ */ // win
    ).withDefault { 0 }

    private val roundEnding = mapOf(
        "A X" to 'Z' /* ๐ฟโคโ๏ธ */, "B X" to 'X' /* ๐โคโ๏ธ */, "C X" to 'Y' /* โ๏ธโค๐ */, // lose
        "A Y" to 'X' /* ๐ฟโค๐ฟ */, "B Y" to 'Y' /* ๐โค๐ */, "C Y" to 'Z' /* โ๏ธโคโ๏ธ */,  // draw
        "A Z" to 'Y' /* ๐ฟโค๐ */, "B Z" to 'Z' /* ๐โคโ๏ธ */, "C Z" to 'X' /* โ๏ธโค๐ฟ */   // win
    )
}