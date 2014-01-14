package batey.akka.testing.backtosender

import akka.actor.Actor
import batey.akka.testing.backtosender.Messages.{Ready, Startup}

class Server extends Actor {
  def receive: Actor.Receive = {
    case Startup => {
      sender ! Ready
    }
    case msg @ _ => {
      println("I should really send something back!")
    }
  }
}

case object Messages {
  case object Startup
  case object Ready
}
