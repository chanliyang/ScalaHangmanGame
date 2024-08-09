package ch.makery.address.view

import ch.makery.address.MainApp
import scalafxml.core.macros.sfxml

@sfxml
class LevelController {

  def handleLevel1(): Unit = {
    MainApp.showGame1()
  }

  def handleLevel2(): Unit = {
    MainApp.showGame2()
  }

  def handleLevel3(): Unit = {
    MainApp.showGame3()
  }

  def handleLevel4(): Unit = {
    MainApp.showGame4()
  }

  def handleLevel5(): Unit = {
    MainApp.showGame5()
  }

  def getMain(): Unit = {
    MainApp.showMain()
  }
}