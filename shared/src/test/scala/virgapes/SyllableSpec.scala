package edu.holycross.shot.virgapes
import org.scalatest.FlatSpec



/**
*/
class SyllableSpec extends FlatSpec {

  "A Syllable" should "have a non-empty vector of neumes" in {
    val neumes = Vector(Neume(1,1,0,0))
    val syll  = Syllable(neumes)
    assert(syll.size > 0)
  }


  it should "object if given an empty vector" in {
    val v = Vector.empty[Neume]
    try {
      val syll = Syllable(v)
      fail( "Should not have made syllable.")

    } catch {
      case iae: IllegalArgumentException => assert(iae.toString == "java.lang.IllegalArgumentException: requirement failed: Cannot create syllable from empty vector.")
      case t : Throwable => fail("Failed with " + t)
    }
  }
}
