import Dependencies._

lazy val myTask = taskKey[Unit]("An example task")


lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.1",
      version      := "1.0.0"      
    )),
    name := "99Problems",
    libraryDependencies += scalaTest % Test,
    myTask := { println("\n\n$name\n\n")}
  )
