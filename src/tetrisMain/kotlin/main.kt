package sample.tetris

import kotlinx.cli.*

fun main(args: Array<String>) {
    val argParser = ArgParser("tetris", useDefaultHelpShortName = false)
    val level by argParser.option(ArgType.Int, shortName = "l", description = "Game level").default(Config.startLevel)
    val width by argParser.option(ArgType.Int, shortName = "w", description = "Width of the game field").default(Config.width)
    val height by argParser.option(ArgType.Int, shortName = "h", description = "Height of the game field").default(Config.height)
    argParser.parse(args)
    val visualizer = SDL_Visualizer(width, height)
    val game = Game(width, height, visualizer, visualizer)
    game.startNewGame(level)

    return
}