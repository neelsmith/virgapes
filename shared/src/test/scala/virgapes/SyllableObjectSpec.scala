package edu.holycross.shot.virgapes
import org.scalatest.FlatSpec



/**
*/
class SyllableObjectSpec extends FlatSpec {

  "The Syllable object" should "make a Syllable from a correctly formatted string" in {
    val neumes = "1.1.0.0"
    val syll  = Syllable(neumes)
    assert(syll.size == 1)

    val n2 = "1.1.0.0 1.2.0.0"
    val syll2 = Syllable(n2)
    assert(syll2.size == 2)
  }

}
