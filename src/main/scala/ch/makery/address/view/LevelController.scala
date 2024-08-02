package ch.makery.address.view

import ch.makery.address.MainApp
import scalafxml.core.macros.sfxml


@sfxml
class LevelController(){

  def handleLevel1(): Unit={
    MainApp.showGame()
  }

  def getMain(): Unit={
    MainApp.showMain()
  }
}