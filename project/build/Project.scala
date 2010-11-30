import sbt._

class Project(info: ProjectInfo) extends DefaultWebProject(info) with AkkaProject  {
  val akkaHttp = akkaModule("http")
  val jetty6 = "org.mortbay.jetty" % "jetty" % "6.1.14" % "test"
}
