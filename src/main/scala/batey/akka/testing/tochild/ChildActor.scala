package batey.akka.testing.tochild

import akka.actor.Actor

class ChildActor extends Actor {
  def receive: Actor.Receive = {
    case msg @ _ => {
      println(s"Received message '${msg}'")
    }
  }
}
