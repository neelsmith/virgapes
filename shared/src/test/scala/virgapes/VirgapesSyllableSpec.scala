package edu.holycross.shot.virgapes



import edu.holycross.shot.mid.validator._
import org.scalatest.FlatSpec
import edu.holycross.shot.cite._
import edu.holycross.shot.ohco2._

class VirgapesSyllableSpec extends FlatSpec {





  "The VirgapesSyllables object" should "have a label" in {
    assert(VirgapesSyllables.orthography == "Virgapes syllabic reading")
  }




  it should "accept digits, white space, periods and hyphens" in  {
    assert (VirgapesSyllables.validString("1"))
    assert(VirgapesSyllables.validString("1.0  - 1.1"))
  }


  it should "identify classes of tokens recognizable from this orthography" in {
    val tokenTypes = VirgapesSyllables.tokenCategories
    assert(tokenTypes.toSet == Set(NeumeSyllableToken))
  }

  it should "tokenize plain-text string for a single neume" in {
    val oneNeume = "1.0.1.0"
    val urn = CtsUrn("urn:cts:testing:dummy.1:1")
    val cn = CitableNode(urn, oneNeume)

    val expectedUrn = CtsUrn("urn:cts:testing:dummy.1._sylls:1.0")
    val expectedResult = Vector( MidToken(expectedUrn, oneNeume, Some(NeumeSyllableToken)))
    val actual = VirgapesSyllables.tokenizeNode(cn)
    assert (actual == expectedResult)
  }
/*
  it should "tokenize plain-text string for a multi-neume syllable" in {
    val multiNeumes = "1.0.1.0-2.0.0.0"
    val expected = Vector( (MidToken(multiNeumes, Some(NeumeSyllableToken))))
    assert (VirgapesSyllables.tokenizeNode(multiNeumes) == expected)
  }

  it should "tokenize multiple neumes" in {
    val twoNeumes = "1.0.1.0 1.0.0.0"
    val expected = Vector(
      MidToken("1.0.1.0", Some(NeumeSyllableToken)),
      MidToken("1.0.0.0", Some(NeumeSyllableToken))
    )
    assert (VirgapesSyllables.tokenizeNode(twoNeumes) == expected)
  }

  it should "tokenize multiple syllables including multineumes syllables" in {
    val twoNeumes = "1.0.1.0-2.0.0.0 1.0.0.0"
    val expected = Vector(
      MidToken("1.0.1.0-2.0.0.0", Some(NeumeSyllableToken)),

      MidToken("1.0.0.0", Some(NeumeSyllableToken))
    )
    assert (VirgapesSyllables.tokenizeNode(twoNeumes) == expected)
  }

  it should "object to invalid characters" in {
      val notANeume = "Verbum domini"
      val expected = Vector(
        MidToken("Verbum", None),
        MidToken("domini", None)
      )
      assert (VirgapesSyllables.tokenizeNode(notANeume) == expected)
  }*/
}
