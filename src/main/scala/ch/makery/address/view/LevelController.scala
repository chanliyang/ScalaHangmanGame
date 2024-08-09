package ch.makery.address.view

import ch.makery.address.MainApp
import scalafxml.core.macros.sfxml

@sfxml
class LevelController {

  def handleLevel1(): Unit = {
    MainApp.showGame(1)
  }

  def handleLevel2(): Unit = {
    MainApp.showGame(2)
  }

  def handleLevel3(): Unit = {
    MainApp.showGame(3)
  }

  def handleLevel4(): Unit = {
    MainApp.showGame(4)
  }

  def handleLevel5(): Unit = {
    MainApp.showGame(5)
  }

  def getMain(): Unit = {
    MainApp.showMain()
  }
}