package ch.makery.address.view

import ch.makery.address.MainApp
import scalafxml.core.macros.sfxml

@sfxml
class LevelController {

  def handleLevel1(): Unit = {
    MainApp.showGame()
  }

  def handleLevel2(): Unit = {
    MainApp.showGame()
  }

  def handleLevel3(): Unit = {
    MainApp.showGame()
  }

  def handleLevel4(): Unit = {
    MainApp.showGame()
  }

  def handleLevel5(): Unit = {
    MainApp.showGame()
  }

  def getMain(): Unit = {
    MainApp.showMain()
  }
}
