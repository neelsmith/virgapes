---
layout: page
title:  Citable passages of text
---


The `Syllabifier` object can create a sequence of `Syllable`s from a citable node of text.  We'll look at the same content as in the [syllables example](../syllables), but instead of reading data from a String, we'll get it from a `CitableNode` (from the `ohco2` library).

In addition to `virgapes`, we'll need to import libaries for working with citable texts:

```tut
import edu.holycross.shot.virgapes._
import edu.holycross.shot.cite._
import edu.holycross.shot.ohco2._
```

Normally, you would probably work with a sequence of citable nodes from an entire corpus of material.  We'll create a single citable node by hand here to show how to work with one.


```tut
val u = CtsUrn("urn:cts:chant:antiphonary.eins121.mid:nativity.3")
val cn = CitableNode(u,"1.2.0.0 1.2.0.0 0.12.0.0-1.3.0.0")
```

Now find a `Vector` of `Syllable`s for this node.  We should have a sequence of three syllables.

```tut

val citedSylls = Syllabifier(cn)
assert(citedSylls.size == 3)
```

As before, the first syllable has one neume, a punctum.

```tut
assert (citedSylls(0).size == 1)
assert(citedSylls(0).neumes(0).neumeType.get == Punctum)
```

The second syllable is identical,  and the third syllable has two neumes (separated by a hyphen  in the intial string).


```tut
assert (citedSylls(2).size == 2)
```
