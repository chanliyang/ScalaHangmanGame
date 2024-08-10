package ch.makery.address.view

import ch.makery.address.MainApp
import ch.makery.address.MainApp.showInstruction
import scalafx.scene.control.{Button, Label}
import scalafx.scene.image.{Image, ImageView}
import scalafxml.core.macros.sfxml

@sfxml
class InstructionController (
                              private val NextInstruction: Button,
                              private val instruction: Label,
                              private val imageView: ImageView
                            ){

  private var currentIndex = 0

  private val images = Array("Images/Instruction/I1.png", "Images/Instruction/I2.png", "Images/Instruction/I3.png", "Images/Instruction/I4.png")
  private val instructions = Array(
    "You are required to guess the word by entering a character",
    "If the character is NOT in the word, the game will let you know",
    "If the character is in the word, the game inform you",
    "Try and guess before all guesses are finished! Good luck!"
  )

  def initialize(): Unit = {
    showInstruction()
  }

  def showInstruction(): Unit = {
    if (currentIndex < instructions.length) {
      imageView.image = new Image(images(currentIndex))
      instruction.text = instructions(currentIndex)
      currentIndex += 1
    } else {
      NextInstruction.disable = true
    }
  }

  def getMain(): Unit = {
    MainApp.showMain()
  }
}


