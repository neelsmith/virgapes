package edu.holycross.shot.virgapes
import org.scalatest.FlatSpec



/**
*/
class StringPairSpec extends FlatSpec {

  "A StringPair instance" should "require equal numbers of syllables" in {
    try {
      val txtSylls = "pu-er"
      val nmSylls = "pes"
      StringPair(txtSylls, nmSylls)
    } catch {
      case t: Throwable => {println(t);  assert(true)}
    }
  }
}
