package batey.akka.testing.toparent

import akka.actor.{Props, ActorSystem}
import akka.testkit.{TestProbe, TestActorRef, TestKit}
import org.scalatest.FunSuiteLike
import org.scalatest.matchers.ShouldMatchers

class ChildActorTest extends TestKit(ActorSystem("ChildActorTest")) with FunSuiteLike with ShouldMatchers {
  test("Should inform parent when told to do something") {
    val parent = TestProbe()
    val underTest = TestActorRef(Props[ChildActor], parent.ref, "ChildActor")

    underTest ! "Do something"

    parent.expectMsg("I was told to do something and I did it")
  }
}
