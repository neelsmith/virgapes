# `virgapes`


## What it is


`virgapes` is a cross-platform library for working with chant encoded in the Virgapes alphabet.

## About the Virgapes alphabet

The Virgapes alphabet defines a system for encoding neumes. It was designed by members of the Chant team of the Holy Cross MID Club.

See some initial docs on the system in this wiki from their wiki:  <https://github.com/HCMID/chant/wiki/The-Virgapes-System>

## Current version: **3.4.0**

Status: **active development**. [Release notes](releases.md)

## License


[GPL 3.0](https://opensource.org/licenses/gpl-3.0.html)

## Documentation

See https://neelsmith.github.io/virgapes/.

## Using, building, testing

`virgapes` can be built for both the JVM and ScalaJS using any version of Scala 2.11 or higher. Binaries for both the JVM and ScalaJS are available from jcenter built with Scala 2.11.8 and 2.12.3. To use the binaries in an sbt project, include Resolver.jcenterRepoin your list of resolvers

    resolvers += Resolver.jcenter

and add this to your library dependencies:

    "edu.holycross.shot.cite" %% "virgapes" % VERSION

For maven, ivy or gradle equivalents, refer to <https://bintray.com/neelsmith/maven/virgapes>.

To build from source and test for a given version, use normal sbt commands (`compile`, `test` ...).

You can also test or run tasks against all versions, using + before the task name. E.g., `sbt "+ test"` runs the `test` task against all versions.
