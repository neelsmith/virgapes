package edu.holycross.shot.virgapes
import org.scalatest.FlatSpec


//import edu.holycross.shot.cite._
//import edu.holycross.shot.ohco2._


class SyllabifierObjectSpec extends FlatSpec {

  "The Syllabifier object" should "make a vector of Syllables from a correctly formatted string" in {
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


}
