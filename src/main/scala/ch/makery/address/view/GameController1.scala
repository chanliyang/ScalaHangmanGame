package ch.makery.address.view

import ch.makery.address.MainApp
import scalafx.scene.control.{Button, Label, TextField}
import scalafx.scene.image.ImageView
import scalafxml.core.macros.sfxml

@sfxml
class GameController1(
                       wordLabel: Label,
                       wordGuessing: Label,
                       GuessLeft: Label,
                       charTextField: TextField,
                       imageView: ImageView,
                       retryButton: Button
                     ) {

  private val completionMessage = "Yay! You guessed the word!"
  private val Game = new BaseGameController("exam", 1, completionMessage, wordLabel, wordGuessing, GuessLeft, charTextField, imageView, retryButton)

  def initialize(): Unit = {
    Game.initialize()
  }

  def submit(): Unit = {
    Game.submit()
  }

  def retry(): Unit = {
    Game.retry()
  }

  def getLevel(): Unit = {
    MainApp.showLevel()
  }
}
