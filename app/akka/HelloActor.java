package akka;

import akka.actor.AbstractLoggingActor;
import play.Logger;

import javax.inject.Inject;

/**
 * Created by Slawomir Leski on 05-07-2018.
 */
public class HelloActor extends AbstractLoggingActor {

	private static final Logger.ALogger LOG = Logger.of(HelloActor.class);

	public final static String NAME = "HELLO_ACTOR";

	@Inject
	public HelloActor() {
		LOG.info("-----------------------------------");
		LOG.info("HelloActor was created");
		LOG.info("-----------------------------------");
	}

	@Override
	public Receive createReceive() {
		LOG.info("--------createReceive()-------");
		log().info("createReceive ----------------------------------------");
		return receiveBuilder().match(String.class, s -> {
			LOG.info("Received String message: {}", s);
		}).matchAny(o -> LOG.info("received unknown message")).build();
	}

	@Override
	public void postStop() throws Exception {

		LOG.info("----------->POST STOP<----------");

		super.postStop();
	}



}
