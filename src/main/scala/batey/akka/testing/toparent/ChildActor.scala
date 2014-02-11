package batey.akka.testing.toparent

import akka.actor.Actor

class ChildActor extends Actor {
  def receive: Actor.Receive = {
    case "Do something" => {
      // Do something important
      context.parent ! "I was told to do something and I did it"
    }
  }
}
