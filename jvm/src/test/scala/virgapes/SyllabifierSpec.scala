package edu.holycross.shot.virgapes
import org.scalatest.FlatSpec

import edu.holycross.shot.ohco2._

//import edu.holycross.shot.cite._
//import edu.holycross.shot.ohco2._


class SyllabifierObjectSpec extends FlatSpec {

  "The Syllabifier object" should "make a vector of Syllables from a correctly formatted string" in pending /*{
    val neumes = "1.1.0.0"
    val sylls  = Syllabifier(neumes)
    assert(sylls.size == 1)

    val n2 = "1.1.0.0 1.2.0.0"
    val sylls2 = Syllabifier(n2)
    assert(sylls2.size == 2)

    val n3 = """1.1.0.0

    1.3.0.1
    1.2.0.0"""
    val sylls3 = Syllabifier(n3)
    assert(sylls3.size == 3)
  }


  it should "create vectors of syllables from XML content" in {
    val xml = """<ab n="2"> 1.1.0.1-0.12.0.0 2.2.0.0 1.1.0.0
    <unclear>1.1.0.0</unclear> 1.1.0.0
    </ab>"""
    val sylls = Syllabifier.fromXml(xml)
    println(sylls)
  }

  it should "create syllabify text from an OHCO2 Corpus of XML documents"in {
    val cex = """urn:cts:chant:antiphonary.einsiedeln121.text_xml:11.introit.1#<ab n="1">0.7.0.0-0.10.0.0-2.2.0.0-0.7.0.0-0.10.0.0</ab>"""
    val cex2 =  """urn:cts:chant:antiphonary.einsiedeln121.text_xml:11.introit.2#<ab n="2">1.1.0.1-0.12.0.0 2.2.0.0 1.1.0.0 1.1.0.0 1.1.0.0 1.1.0.0</ab>"""

    val c = Corpus (cex + "\n" + cex2)
    val sylls = Syllabifier.fromXmlCorpus(c)
    val expectedSize = 7
    assert(sylls.size == expectedSize)

  }*/


}
