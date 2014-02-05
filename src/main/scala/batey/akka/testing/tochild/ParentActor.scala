package batey.akka.testing.tochild

import akka.actor.{ActorRef, ActorRefFactory, Actor}

class ParentActor(childFactory: (ActorRefFactory) => ActorRef) extends Actor {
  def receive: Actor.Receive = {
    case msg @ _ => {
      println(s"Received msg, delegating work to a child actor")
      val childActor = childFactory(context)
      childActor ! "Go and do something important!"
    }
  }
}
