package edu.holycross.shot.virgapes
import org.scalatest.FlatSpec
import edu.holycross.shot.cite._
import edu.holycross.shot.ohco2._


/**
*/
class SyllableObjectSpec extends FlatSpec {

  "The Syllable object" should "make a vector of Syllables from a correctly formatted string" in {
    val neumes = "1.1.0.0"
    val sylls  = Syllable(neumes)
    assert(sylls.size == 1)

    val n2 = "1.1.0.0 1.2.0.0"
    val sylls2 = Syllable(n2)
    assert(sylls2.size == 2)

    val n3 = """1.1.0.0

    1.3.0.1
    1.2.0.0"""
    val sylls3 = Syllable(n3)
    assert(sylls3.size == 3)
  }

  it should "make a vector of Syllables from an ohco2 CitableNode" in {
    val txt = "1.2.0.0 1.2.0.0 0.12.0.0-1.3.0.0"
    val u = CtsUrn("urn:cts:chant:antiphonary.eins121.mid:nativity.3")
    val cn = CitableNode(u,txt)
    val sylls = Syllable(cn)

    val expectedSyllables = 3
    assert(sylls.size == expectedSyllables)

    val oneSyllable = sylls(2)
    val expectedNeumes = 2
    assert(oneSyllable.size == expectedNeumes)

    val punct = sylls(0).neumes(0)
      assert(punct.neumeType.get == Punctum)
  }


}
