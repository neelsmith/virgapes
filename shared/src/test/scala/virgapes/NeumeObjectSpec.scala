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

  it should "find NeumeType for values" in {
    assert(Neume.neumeType(0,1).get == SignificativeA)
    assert(Neume.neumeType(0,2).get == SignificativeB)
    assert(Neume.neumeType(0,3).get == SignificativeC)
    assert(Neume.neumeType(0,4).get == SignificativeE)
    assert(Neume.neumeType(0,5).get == SignificativeF)
    assert(Neume.neumeType(0,6).get == SignificativeI)
    assert(Neume.neumeType(0,7).get == SignificativeK)
    assert(Neume.neumeType(0,8).get == SignificativeL)
    assert(Neume.neumeType(0,9).get == SignificativeM)
    assert(Neume.neumeType(0,10).get == SignificativeP)
    assert(Neume.neumeType(0,11).get == SignificativeS)
    assert(Neume.neumeType(0,12).get == SignificativeT)
    assert(Neume.neumeType(0,13).get == SignificativeV)
    assert(Neume.neumeType(0,14).get == SignificativeX)            
  }
}
