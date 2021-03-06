package edu.holycross.shot.virgapes
import org.scalatest.FlatSpec



/**
*/
class NeumeTypeSpec extends FlatSpec {


  "The NeumeType trait" should "recognize a virga" in {
    assert(Virga.name == "virga")
    assert(Virga.pitches == 1)
  }
  it should "recognize a punctum" in {
    assert(Punctum.name == "punctum")
    assert(Punctum.pitches == 1)
  }
  it should "recognize an apostrophe" in {
    assert(Apostrophe.name == "apostrophe")
    assert(Apostrophe.pitches == 1)
  }
  it should "recognize a quilisma" in {
    assert(Quilisma.name == "quilisma")
    assert(Quilisma.pitches == 1)
  }

  it should "recognize a clivis" in {
    assert(Clivis.name == "clivis")
    assert(Clivis.pitches == 2)
  }

  it should "recognize a pes" in {
    assert(Pes.name == "pes")
    assert(Pes.pitches == 2)
  }

  it should "recognize a distropha" in {
    assert(Distropha.name == "distropha")
    assert(Distropha.pitches == 2)
  }

  it should "recognize a bivirga " in {
    assert(Bivirga.name == "bivirga")
    assert(Bivirga.pitches == 2)
  }

  it should "recognize a pes quassus" in {
    assert(PesQuassus.name == "pes quassus")
    assert(PesQuassus.pitches == 2)
  }


  it should "recognize a porrectus" in {
    assert(Porrectus.name == "porrectus")
    assert(Porrectus.pitches == 3)
  }
  it should "recognize a torculus" in {
    assert(Torculus.name == "torculus")
    assert(Torculus.pitches == 3)
  }
  it should "recognize a climacus" in {
    assert(Climacus.name == "climacus")
    assert(Climacus.pitches == 3)
  }
  it should "recognize a scandicus" in {
    assert(Scandicus.name == "scandicus")
    assert(Scandicus.pitches == 3)
  }
  it should "recognize a tristropha" in {
    assert(Tristropha.name == "tristropha")
    assert(Tristropha.pitches == 3)
  }
  it should "recognize a trisvirga" in {
    assert(Trisvirga.name == "trisvirga")
    assert(Trisvirga.pitches == 3)
  }
  it should "recognize a trigon" in {
    assert(Trigon.name == "trigon")
    assert(Trigon.pitches == 3)
  }

  it should "recognize a porrectus flexus" in {
    assert(PorrectusFlexus.name == "porrectus flexus")
    assert(PorrectusFlexus.pitches == 4)
  }
  it should "recognize a subbipunctis" in {
    assert(PesSubBipunctis.name == "pes subbipunctis")
    assert(PesSubBipunctis.pitches == 4)
  }
  it should "recognize a scandicus flexus" in {
    assert(ScandicusFlexus.name == "scandicus flexus")
    assert(ScandicusFlexus.pitches == 4)
  }
  it should "recognize a torculus resupinus" in {
    assert(TorculusResupinus.name == "torculus resupinus")
    assert(TorculusResupinus.pitches == 4)
  }

  it should "recognize a significative letter 'a'" in {
    assert(SignificativeA.name == "a")
    assert(SignificativeA.pitches == 0)
  }
  it should "recognize a significative letter 'b'" in {
    assert(SignificativeB.name == "b")
    assert(SignificativeB.pitches == 0)
  }

  it should "recognize a significative letter 'c'" in {
    assert(SignificativeC.name == "c")
    assert(SignificativeC.pitches == 0)
  }
  it should "recognize a significative letter 'e'" in {
    assert(SignificativeE.name == "e")
    assert(SignificativeE.pitches == 0)
  }
  it should "recognize a significative letter 'f'" in {
    assert(SignificativeF.name == "f")
    assert(SignificativeF.pitches == 0)
  }
  it should "recognize a significative letter 'i'" in {
    assert(SignificativeI.name == "i")
    assert(SignificativeI.pitches == 0)
  }
  it should "recognize a significative letter 'k'" in {
    assert(SignificativeK.name == "k")
    assert(SignificativeK.pitches == 0)
  }
  it should "recognize a significative letter 'l'" in {
    assert(SignificativeL.name == "l")
    assert(SignificativeL.pitches == 0)
  }
  it should "recognize a significative letter 'm'" in {
    assert(SignificativeM.name == "m")
    assert(SignificativeM.pitches == 0)
  }

  it should "recognize a significative letter 'p'" in {
    assert(SignificativeP.name == "p")
    assert(SignificativeP.pitches == 0)
  }
  it should "recognize a significative letter 's'" in {
    assert(SignificativeS.name == "s")
    assert(SignificativeS.pitches == 0)
  }
  it should "recognize a significative letter 't'" in {
    assert(SignificativeT.name == "t")
    assert(SignificativeT.pitches == 0)
  }
  it should "recognize a significative letter 'v'" in {
    assert(SignificativeV.name == "v")
    assert(SignificativeV.pitches == 0)
  }
  it should "recognize a significative letter 'x'" in {
    assert(SignificativeX.name == "x")
    assert(SignificativeX.pitches == 0)
  }
}
