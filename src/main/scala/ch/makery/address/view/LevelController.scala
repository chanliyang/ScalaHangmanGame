package ch.makery.address.view

import ch.makery.address.MainApp
import scalafxml.core.macros.sfxml


@sfxml
class LevelController(){

  def handleLevel1(): Unit={
    MainApp.showGame("tree")
  }

  def handleLevel2(): Unit={
    MainApp.showGame("car")
  }

  def handleLevel3(): Unit={
    MainApp.showGame("house")
  }

  def handleLevel4(): Unit={
    MainApp.showGame("fish")
  }

  def handleLevel5(): Unit={
    MainApp.showGame("burger")
  }

  def getMain(): Unit={
    MainApp.showMain()
  }
}