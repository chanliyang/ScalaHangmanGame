package ch.makery.address.view

import ch.makery.address.MainApp
import scalafx.scene.control.{Button, Label, TextField}
import scalafx.scene.image.ImageView
import scalafxml.core.macros.sfxml

@sfxml
class GameController2(
                       wordLabel: Label,
                       wordGuessing: Label,
                       GuessLeft: Label,
                       charTextField: TextField,
                       imageView: ImageView,
                       retryButton: Button
                     ) {

  private val completionMessage = "The cockroach crawled away!"
  private val Game = new BaseGameController("dirty", 2, completionMessage, wordLabel, wordGuessing, GuessLeft, charTextField, imageView, retryButton)

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
