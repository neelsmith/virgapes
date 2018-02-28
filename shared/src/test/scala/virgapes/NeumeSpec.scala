package edu.holycross.shot.virgapes
import org.scalatest.FlatSpec



/**
*/
class NeumesSpec extends FlatSpec {


  "A Neume" should "have four syntactic components encoded as Ints" in {
    val neume = Neume(1,1,0,0)

    assert(neume.pitches == 1)
    assert(neume.neume == 1)
    assert(neume.episema == 0)
    assert(neume.liquescence == 0)
  }
}
