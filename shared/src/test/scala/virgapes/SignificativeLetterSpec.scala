package edu.holycross.shot.virgapes
import org.scalatest.FlatSpec



/**
*/
class SignificativeLetterSpec extends FlatSpec {

  "A Neume" should "recognize significative letter a" in {
    val neume = Neume(0,1,0,0)
    val expected = "a"
    assert(neume.name == expected)
  }

  it should "recognize significative letter c" in {
    val neume = Neume(0,3,0,0)
    val expected = "c"
    assert(neume.name == expected)
  }
  it should "recognize significative letter e" in {
    val neume = Neume(0,5,0,0)
    val expected = "e"
    assert(neume.name == expected)
  }

}
