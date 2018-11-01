package edu.holycross.shot.virgapes



import edu.holycross.shot.mid.validator._
import org.scalatest.FlatSpec
import edu.holycross.shot.cite._

class VirgapesSyllableSpec extends FlatSpec {


  val neumesDoc = CtsUrn("urn:cts:chant:massordinary.sg359.neumes:")
  val ortho = VirgapesSyllables(neumesDoc)

  "A VirgapesSyllables orthography" should "have a label" in {
    assert(ortho.orthography == "Virgapes syllabic reading")
  }


  it should "recognize its domain" in {
    assert(ortho.inDomain(CtsUrn("urn:cts:chant:massordinary.sg359.neumes:")))

    assert(ortho.inDomain(CtsUrn("urn:cts:chant:massordinary.sg359.text:")) == false)

  }


  it should "accept digits, white space, periods and hyphens" in {
    assert (ortho.validString("1"))
    assert(ortho.validString("1.0  - 1.1"))
  }


  it should "identify classes of tokens recognizable from this orthography" in {
    val tokenTypes = ortho.tokenCategories
    assert(tokenTypes.toSet == Set(NeumeSyllableToken))
  }

  it should "tokenize plain-text string for a single neume" in {
    val oneNeume = "1.0.1.0"
    val expectedOne = Vector( MidToken(oneNeume, Some(NeumeSyllableToken)))
    assert (ortho.tokenizeString(oneNeume) == expectedOne)
  }

  it should "tokenize plain-text string for a multi-neume syllable" in {
    val multiNeumes = "1.0.1.0-2.0.0.0"
    val expected = Vector( (MidToken(multiNeumes, Some(NeumeSyllableToken))))
    assert (ortho.tokenizeString(multiNeumes) == expected)
  }

  it should "tokenize multiple neumes" in {
    val twoNeumes = "1.0.1.0 1.0.0.0"
    val expected = Vector(
      MidToken("1.0.1.0", Some(NeumeSyllableToken)),
      MidToken("1.0.0.0", Some(NeumeSyllableToken))
    )
    assert (ortho.tokenizeString(twoNeumes) == expected)
  }

  it should "tokenize multiple syllables including multineumes syllables" in {
    val twoNeumes = "1.0.1.0-2.0.0.0 1.0.0.0"
    val expected = Vector(
      MidToken("1.0.1.0-2.0.0.0", Some(NeumeSyllableToken)),

      MidToken("1.0.0.0", Some(NeumeSyllableToken))
    )
    assert (ortho.tokenizeString(twoNeumes) == expected)
  }

  it should "object to invalid characters" in {
      val notANeume = "Verbum domini"
      val expected = Vector(
        MidToken("Verbum", None),
        MidToken("domini", None)
      )
      assert (ortho.tokenizeString(notANeume) == expected)
  }
}
