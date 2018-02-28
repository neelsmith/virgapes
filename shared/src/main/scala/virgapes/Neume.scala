package edu.holycross.shot.virgapes

case class Neume(pitches: Int, neume: Int, episema: Int, liquescence: Int) {





  require(validNeume)

  def validNeume: Boolean = {
    require((0 to 4).toVector.contains(pitches))
    require(neume > 0)
    require((0 to 2).toVector.contains(episema))
    require((0 to 1).toVector.contains(liquescence))
    true
  }
}
