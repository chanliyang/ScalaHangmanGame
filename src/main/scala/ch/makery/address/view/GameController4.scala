package ch.makery.address.view

import ch.makery.address.MainApp
import scalafx.scene.control.{Button, Label, TextField}
import scalafx.scene.image.ImageView
import scalafxml.core.macros.sfxml

@sfxml
class GameController4(
                       wordLabel: Label,
                       wordGuessing: Label,
                       GuessLeft: Label,
                       charTextField: TextField,
                       imageView: ImageView,
                       retryButton: Button
                     ) {

  private val completionMessage = "Thank God the baby didn't fall!"
  private val Game = new BaseGameController("milk", 4, completionMessage, wordLabel, wordGuessing, GuessLeft, charTextField, imageView, retryButton)

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
