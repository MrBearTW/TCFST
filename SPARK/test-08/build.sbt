val myName = "FlightDelay"
val myScalaVersion = "2.11"
val myVersion = "0.1"

val JarFile = " target/scala-"+myScalaVersion+"/" + myName.toLowerCase+"_"+myScalaVersion+"-"+myVersion+".jar"
val DataFile= " /home/williamlee/tmp/spark/t6/r1.csv"
val DataPath= " /home/williamlee/tmp/spark/t6/"

name         := myName
scalaVersion := myScalaVersion+".8"
version      := myVersion

val overrideScalaVersion = "2.11.8"

//Override Scala Version to the above 2.11.8 version
ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) }

resolvers ++= Seq(
  "All Spark Repository -> bintray-spark-packages" at "https://dl.bintray.com/spark-packages/maven/"
)

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.1.0" % "provided",
  "org.apache.spark" %% "spark-sql"  % "2.1.0" % "provided",
  "org.apache.spark" %% "spark-mllib"% "2.1.0" % "provided",
  "org.scalatest"    %% "scalatest"  % "2.2.1" % "test"
)

lazy val local = taskKey[Unit]("Execute the spark-submit local[*]")
local := {
  val s: TaskStreams = streams.value
  "spark-submit --class example." + myName + 
              " --master local[*] " + JarFile + DataFile !
}

lazy val local2 = taskKey[Unit]("Execute the spark-submit local[*]")
local2 := {
  "spark-submit --class example." + myName + "SQL " +
              " --master local[*] " + JarFile + " " + System.getenv("PWD")+"/r3.csv" !
}

lazy val local3 = taskKey[Unit]("Execute the spark-submit local[*]")
local3 := {
  "spark-submit --class example." + myName + "SQL2 " +
    " --master local[*] " + JarFile + " " + System.getenv("PWD")+"/r3.csv" !
}

lazy val spark = taskKey[Unit]("Execute the spark-submit stand-alone")
spark := {
  val s: TaskStreams = streams.value

  "spark-submit --class example." + myName + 
              " --master spark://172.17.0.1:7077 " + 
                  JarFile !
}

lazy val yarn = taskKey[Unit]("Execute the spark-submit yarn")
yarn := {
  val s: TaskStreams = streams.value
  "spark-submit --class example." + myName + 
              " --master yarn --deploy-mode cluster " + 
              JarFile !
}
