package edu.holycross.shot.virgapes
import org.scalatest.FlatSpec

import edu.holycross.shot.ohco2._
import edu.holycross.shot.cite._
import edu.holycross.shot.mid.latinmodel._

/**
*/
class AlignedWordSpec extends FlatSpec {

  val textCex = """urn:cts:chant:antiphonary.einsiedeln121.text_xml:11.introit.1#<ab n="1">Puer natus est...</ab>"""
  val text = Corpus(textCex)

  val neumeCex = """urn:cts:chant:antiphonary.einsiedeln121.neumes_xml:11.introit.1#<ab n="1"> 0.7.0.0-0.10.0.0-2.2.0.0-0.7.0.0-0.10.0.0 0.5.0.0-1.1.0.0  0.5.0.0-3.2.0.0 1.2.1.0 3.5.0.0</ab>"""
  val neumes = Corpus(neumeCex)

  "An AlignedWord" should "display text content sylalbified with hypens" in {
    val alignment = Aligner.alignMidCorpora(neumes, text)
    val words = alignment.map(AlignedWord(_))
    val word1 = words(0)
    val expected = "pu-er"
    assert(word1.text == expected)
  }
}
