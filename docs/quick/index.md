---
layout: page
title:  Quick start
---


Import the library:


```scala
import edu.holycross.shot.virgapes._
```



## `Neume`s

The basic object in the library is a `Neume`.  You can create it from a `String` in virgapes notation, and then work with the neume's components.

Example:  the string `1.2.0.0` represents a one-syllable neume with ID 2, no episema (ie, episema on syllable 0), and no liquescence.


```scala
val neume = Neume("1.2.0.0")
assert(neume.name == "punctum")
assert(neume.pitches == 1)
assert(neume.episema == 0)
assert(neume.liquescence == false)
```

You can also retrieve a `NeumeType`  option for a `Neume`.

```scala
val nType = neume.neumeType
assert(nType.get == Punctum)
```

See the API docs for  more information.

## `Syllable`s

A `Syllable` has a vector of `Neume`s.  You can create a Vector of `Syllable`s from a `String`.  Syllables are separated by white space;  within a single syllable, neumes are separated by hyphens.

Example:  the string `1.2.0.0 1.2.0.0 0.12.0.0-1.3.0.0` represents three syllables.  The first and second syllable each have one neume;  the final syllable has two neumes.

```scala
val sylls =  Syllable("1.2.0.0 1.2.0.0 0.12.0.0-1.3.0.0")
assert(sylls.size == 3)

val s1 = sylls(0)
assert (s1.size == 1)
val n1 = s1.neumes(0)
assert(n1.neumeType.get == Punctum)
assert(n1.episema == 0)
assert(n1.liquescence == false)
```


## Citable texts


Instantiating `Neume`s and `Syllable`s from citable sources using the `ohco2`  library.
