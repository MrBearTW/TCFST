val myName = "SimpleApp"
val myScalaVersion = "2.11"
val myVersion = "0.1"
val JarFile = " target/scala-"+myScalaVersion+"/" + myName.toLowerCase+"_"+myScalaVersion+"-"+myVersion+".jar"

name := myName

version := myVersion

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.2.0" % "provided",
  "org.apache.spark" %% "spark-sql" % "2.2.0" % "provided"
)

lazy val local = taskKey[Unit]("Execute the spark-submit local[*]")
local := {
  val s: TaskStreams = streams.value
  "spark-submit --class " + myName + " --master local[*] " + JarFile  !
}
