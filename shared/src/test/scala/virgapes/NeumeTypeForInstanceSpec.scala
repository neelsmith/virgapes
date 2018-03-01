package edu.holycross.shot.virgapes
import org.scalatest.FlatSpec



/**
*/
class NeumeTypeForInstanceSpec extends FlatSpec {

  "A Neume" should "identify virga from integer values" in {
    val n = Neume(1,1,0,false)
    assert (n.neumeType.get == Virga)
  }

  it should "identify punctum from integer values" in {
    val n = Neume(1,2,0,false)
    assert (n.neumeType.get == Punctum)
  }

  it should "identify apostrophe from integer values" in {
    val n = Neume(1,3,0,false)
    assert (n.neumeType.get == Apostrophe)
  }

  it should "identify quilisma from integer values" in {
    val n = Neume(1,4,0,false)
    assert (n.neumeType.get == Quilisma)
  }
}
