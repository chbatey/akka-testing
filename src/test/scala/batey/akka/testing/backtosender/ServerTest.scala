package batey.akka.testing.backtosender

import akka.testkit.{ImplicitSender, TestKit}
import akka.actor.{Props, ActorSystem}
import org.scalatest.FunSuiteLike

class ServerTest extends TestKit(ActorSystem("TestSystem")) with FunSuiteLike with ImplicitSender {
  test("Should send back Ready message when Startup message is received") {
    val actorRef = system.actorOf(Props[Server])

    actorRef ! Messages.Startup

    expectMsg(Messages.Ready)
  }
}
