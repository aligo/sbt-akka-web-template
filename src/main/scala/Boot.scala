package hello.world

import se.scalablesolutions.akka.config.ScalaConfig._
import se.scalablesolutions.akka.actor.{ActorRegistry, SupervisorFactory, Actor}
class Boot {
  val factory = SupervisorFactory(
    SupervisorConfig(
      RestartStrategy(OneForOne, 3, 100, List(classOf[Exception])),
      Supervise(Actor.actorOf[HelloWorldActor], LifeCycle(Permanent)) :: Nil))
  factory.newInstance.start
}
