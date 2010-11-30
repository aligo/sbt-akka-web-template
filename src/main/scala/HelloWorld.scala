package hello.world

import javax.ws.rs.{GET, Path, Produces}
import se.scalablesolutions.akka.actor.{ActorRegistry, SupervisorFactory, Actor}

private case object Hello

@Path("/")
class HelloWorld {
  @GET
  @Produces(Array("text/html"))
  def hello = {
    val HelloWorld = ActorRegistry.actorFor[HelloWorldActor].get
    (HelloWorld !! Hello).getOrElse("Failed")

  }
}

class HelloWorldActor extends Actor {
  import self._

  def receive = {
    case Hello => reply(<h1>Hello World!</h1>.toString)
  }
}
