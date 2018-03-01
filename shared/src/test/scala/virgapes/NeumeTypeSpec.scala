package edu.holycross.shot.virgapes
import org.scalatest.FlatSpec



/**
*/
class NeumeTypeSpec extends FlatSpec {


  "The NeumeType trait" should "recognize a Virga" in {
    assert(Virga.name == "virga")
    assert((Virga.pitches == 1))
  }
  it should "recognize a pes" in {
    assert(Pes.name == "pes")
    assert((Pes.pitches == 1))
  }
}
