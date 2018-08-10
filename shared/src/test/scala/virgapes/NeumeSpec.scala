package edu.holycross.shot.virgapes
import org.scalatest.FlatSpec



/**
*/
class NeumeSpec extends FlatSpec {

  "A Neume" should "have four syntactic components" in {
    val neume = Neume(1,1,0,0)

    assert(neume.pitches == 1)
    assert(neume.neume == 1)
    assert(neume.episema == 0)
    assert(neume.liquescence == 0)
  }

  it should "object if episema value is greater than number of pitches" in {
    try {
      val neume = Neume(1,1,2,0)
      fail("Should not have made neume with bad data for episema.")
    } catch {
      case iae: IllegalArgumentException => assert(iae.toString == "java.lang.IllegalArgumentException: requirement failed: Episema (2) cannot be greater than total number of pitches (1)")
      case t: Throwable => fail("Should have failed with IllegalArgumentException but got " + t)
    }
  }

  it should "find the type for neume" in {
    val neume = Neume(1,1,0,0)
    val expectedType = Virga
    assert (neume.neumeType.get == expectedType)

  }

  it should "find the name for an identified neume" in {
    val neume = Neume(1,1,0,0)
    val expected = "virga"
    assert(neume.name == expected)
  }

  it should "reject invalid combinations of neueme ID and number of pitches"  in {
    try {
      val badId = 999999
      val neume2 = Neume(1,badId,0,0)
      fail("Should not have created neume")
    } catch {
      case ia: IllegalArgumentException => assert(ia.toString == "java.lang.IllegalArgumentException: requirement failed: Invalid ID 999999 for neume with one syllable.")
      case t: Throwable => fail("Should have gotten IllegalArgumentException but got " + t)
    }
  }

  it should "ensure that the number of pitches for a neume type is the same as the number of pitches for an instance of a neueme" in {
    val neume = Neume(1,1,0,0)
    assert(neume.pitches == neume.neumeType.get.pitches  )
  }

  it should "serialize to Virgapes format" in {
    val neume = Neume(1,1,0,0)
    val expected = "1.1.0.0"
    assert(neume.toString == expected)
  }
}
