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
}
