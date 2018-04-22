---
layout: page
title:  Syllables
---


A `Syllable` has a vector of `Neume`s.  You can create a Vector of `Syllable`s from a `String`.  Syllables are separated by white space;  within a single syllable, neumes are separated by hyphens.

Example:  the string `1.2.0.0 1.2.0.0 0.12.0.0-1.3.0.0` represents three syllables.  The first and second syllable each have one neume;  the final syllable has two neumes.

```scala
import edu.holycross.shot.virgapes._


val sylls =  Syllable("1.2.0.0 1.2.0.0 0.12.0.0-1.3.0.0")
assert(sylls.size == 3)

val s1 = sylls(0)
assert (s1.size == 1)
val n1 = s1.neumes(0)
assert(n1.neumeType.get == Punctum)
assert(n1.episema == 0)
assert(n1.liquescence == false)
```
