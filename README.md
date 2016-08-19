Mixer2
======================
[![Gitter](https://badges.gitter.im/JoinChat.svg)](https://gitter.im/nabedge/mixer2?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

XHTML template engine for java.
see http://mixer2.org/site/

The sample projects are https://github.com/nabedge/mixer2-sample

----

## BEFORE import int IDE (IntelliJ, Eclipse, etc.)

The JAXB source code auto generation should be run in "compile" phase in maven.

1. git clone [this repository]
2. export MAVEN_OPTS=-Xmx512m
3. mvn clean compile
4. import projects into Intellij or Eclipse as a maven project.
