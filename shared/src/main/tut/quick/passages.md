---
layout: page
title:  Citable passages of text
---




The following example uses the same data as the previous example, but draws it from a `CitableNode`.

```tut:silent
import edu.holycross.shot.virgapes._
import edu.holycross.shot.cite._
import edu.holycross.shot.ohco2._


val u = CtsUrn("urn:cts:chant:antiphonary.eins121.mid:nativity.3")
val cn = CitableNode(u,"1.2.0.0 1.2.0.0 0.12.0.0-1.3.0.0")
val citedSylls = Syllable(cn)

val cited1 = citedSylls(0)
assert (cited1.size == 1)
val citedNeume1 = cited1.neumes(0)
assert(citedNeume1.neumeType.get == Punctum)
assert(citedNeume1.episema == 0)
assert(citedNeume1.liquescence == false)
```
