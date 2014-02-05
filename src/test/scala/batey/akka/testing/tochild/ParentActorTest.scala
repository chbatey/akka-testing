package batey.akka.testing.tochild

import org.scalatest.FunSuiteLike
import akka.testkit.{TestProbe, TestKit, TestActorRef}
import akka.actor.{Props, ActorSystem}

class ParentActorTest extends TestKit(ActorSystem("TestSystem")) with FunSuiteLike {
  test("Should delegate the important work to the client") {
    val testProbeForChild = TestProbe()
    val underTest = TestActorRef(new ParentActor(_ => testProbeForChild.ref))

    underTest ! "Go do some work"

    testProbeForChild.expectMsg("Go and do something important!")
  }

  test("Using a real child actor") {
    val underTest = TestActorRef(new ParentActor(actorFactory => actorFactory.actorOf(Props[ChildActor])))

    underTest ! "Go do some work"

    // Can't test this but shows how to crate a ParentActor in production code
  }
}
