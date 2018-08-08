package edu.holycross.shot.virgapes
import org.scalatest.FlatSpec

import edu.holycross.shot.ohco2._
import edu.holycross.shot.cite._
import edu.holycross.shot.mid.latinmodel._

/**
*/
class AlignerSpec extends FlatSpec {



  "The Aligner object" should "syllabify a corpus of MID-complinat XML of Latin text into a Vector of lower case strings" in {
    val urn = CtsUrn("urn:cts:chant:antiphonary.einsiedeln121.text_xml:11.introit.1")
    val  xmlSrc = """<ab n="1">Puer</ab>"""
    val cn = CitableNode(urn, xmlSrc)
    val c = Corpus(Vector(cn))

    val syllabified = Aligner.syllabifyMidXml(c)
    val word1 = syllabified(0)
    val expected = Vector("pu", "er")
    assert(word1 == expected)
  }

  it should "ignore non-lexical tokens in syllabifying text" in {
    val urn = CtsUrn("urn:cts:chant:antiphonary.einsiedeln121.text_xml:11.introit.1")
    val  xmlSrc = """<ab n="1">Puer natus est.  Et filius datus est nobis.</ab>"""
    val cn = CitableNode(urn, xmlSrc)
    val c = Corpus(Vector(cn))

    val syllabified = Aligner.syllabifyMidXml(c)
    val expectedSize = 8
    assert(syllabified.size == expectedSize)

    val expectedLast = Vector("no", "bis")
    assert(syllabified(7) == expectedLast)
  }

  it should "align syllables of Latin text with syllables of neumes" in {
    val urn = CtsUrn("urn:cts:chant:antiphonary.einsiedeln121.text_xml:11.introit.1")
    val  textXml = """<ab n="1">Puer natus est...</ab>"""
    val cn = CitableNode(urn, textXml)
    val c = Corpus(Vector(cn))

    val neumeXml = """<ab n="1"> 0.7.0.0-0.10.0.0-2.2.0.0-0.7.0.0-0.10.0.0
    0.5.0.0-1.1.0.0
    0.5.0.0-3.2.0.0 1.2.1.0
    </ab>"""
    val neumeSylls = Syllabifier.fromXml(neumeXml)

    Aligner.alignXml(neumeSylls, c)
  }
}
