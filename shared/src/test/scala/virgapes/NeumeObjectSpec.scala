package edu.holycross.shot.virgapes
import org.scalatest.FlatSpec



/**
*/
class NeumeObjectSpec extends FlatSpec {


  "The Neume object" should "build Neumes from strings" in {
    val neume = Neume("1.1.0.0")
    assert(neume.pitches == 1)
    assert(neume.neume == 1)
    assert(neume.episema == 0)
    assert(neume.liquescence == false)
  }

  it should "build Neuemes from Vectors of Ints" in {
    val neume = Neume(Vector(1,1,0,0))
    assert(neume.pitches == 1)
    assert(neume.neume == 1)
    assert(neume.episema == 0)
    assert(neume.liquescence == false)
  }
}
