package edu.holycross.shot.virgapes
import org.scalatest.FlatSpec

import edu.holycross.shot.cite._
import edu.holycross.shot.ohco2._

/**
*/
class SyllableSourceSpec extends FlatSpec {

  "The Syllable object" should "parse a CitableNode into a vector of Syllables" in {
    val catCex = "jvm/src/test/resources/ctscatalog.cex"
    val citeConf = "jvm/src/test/resources/citationconfig.cex"
    val baseDir = "jvm/src/test/resources"
    val xmlRepo = TextRepositorySource.fromFiles(catCex,citeConf,baseDir)

    val cex = "jvm/src/test/resources/einsneumes.cex"
    val repo = TextRepositorySource.fromCexFile(cex,"#")

    val n = repo.corpus.nodes(0)
    val syll = Syllable(n)
    val expectedSyllables = 49
    assert(syll.size == expectedSyllables)
  }


  // don't know why this fails to find CtsUrn class in JS...


    "A Syllable" should "make a vector of Syllables from an ohco2 CitableNode" in {
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
