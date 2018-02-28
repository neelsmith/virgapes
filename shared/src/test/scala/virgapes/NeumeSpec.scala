package edu.holycross.shot.virgapes
import org.scalatest.FlatSpec



/**
*/
class NeumeSpec extends FlatSpec {

  "A Neume" should "have four syntactic components" in {
    val neume = Neume(1,1,0,false)

    assert(neume.pitches == 1)
    assert(neume.neume == 1)
    assert(neume.episema == 0)
    assert(neume.liquescence == false)
  }

  it should "object if episema value is greater than number of pitches" in {
    try {
      val neume = Neume(1,1,2,false)
      fail("Should not have made neume with bad data for episema.")
    } catch {
      case iae: IllegalArgumentException => assert(iae.toString == "java.lang.IllegalArgumentException: requirement failed: Episema (2) cannot be greater than total number of pitches (1)")
      case t: Throwable => fail("Should have failed with IllegalArgumentException but got " + t)
    }

  }
}
