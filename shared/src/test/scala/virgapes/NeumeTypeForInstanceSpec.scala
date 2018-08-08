package edu.holycross.shot.virgapes
import org.scalatest.FlatSpec

/**
*/
class NeumeTypeForInstanceSpec extends FlatSpec {

  "A Neume" should "identify virga from integer values" in {
    val n = Neume(1,1,0,0)
    assert (n.neumeType.get == Virga)
  }

  it should "identify punctum from integer values" in {
    val n = Neume(1,2,0,0)
    assert (n.neumeType.get == Punctum)
  }

  it should "identify apostrophe from integer values" in {
    val n = Neume(1,3,0,0)
    assert (n.neumeType.get == Apostrophe)
  }

  it should "identify quilisma from integer values" in {
    val n = Neume(1,4,0,0)
    assert (n.neumeType.get == Quilisma)
  }

  it should "identify clivis from integer values" in {
    val n = Neume(2,1,0,0)
    assert (n.neumeType.get == Clivis)
  }
  it should "identify pes from integer values" in {
    val n = Neume(2,2,0,0)
    assert (n.neumeType.get == Pes)
  }
  it should "identify distropha from integer values" in {
    val n = Neume(2,3,0,0)
    assert (n.neumeType.get == Distropha)
  }
  it should "identify bivirga from integer values" in {
    val n = Neume(2,4,0,0)
    assert (n.neumeType.get == Bivirga)
  }
  it should "identify pes quassus from integer values" in {
    val n = Neume(2,5,0,0)
    assert (n.neumeType.get == PesQuassus)
  }

  it should "identify porrectus from integer values" in {
    val n = Neume(3,1,0,0)
    assert (n.neumeType.get == Porrectus)
  }
  it should "identify torculus from integer values" in {
    val n = Neume(3,2,0,0)
    assert (n.neumeType.get == Torculus)
  }
  it should "identify climacus from integer values" in {
    val n = Neume(3,3,0,0)
    assert (n.neumeType.get == Climacus)
  }
  it should "identify scandicus from integer values" in {
    val n = Neume(3,4,0,0)
    assert (n.neumeType.get == Scandicus)
  }
  it should "identify tristropha from integer values" in {
    val n = Neume(3,5,0,0)
    assert (n.neumeType.get == Tristropha)
  }
  it should "identify trisvrga from integer values" in {
    val n = Neume(3,6,0,0)
    assert (n.neumeType.get == Trisvirga)
  }
  it should "identify trigon from integer values" in {
    val n = Neume(3,7,0,0)
    assert (n.neumeType.get == Trigon)
  }
}
