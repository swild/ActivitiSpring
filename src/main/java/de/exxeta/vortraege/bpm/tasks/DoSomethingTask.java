package de.exxeta.vortraege.bpm.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DoSomethingTask {

    private static final Logger LOG = LoggerFactory.getLogger(DoSomethingTask.class);

    private boolean didSomething = false;

    public void reset() {
        didSomething = false;
    }

    public void doSomething() {
        LOG.info("Do something.");

        didSomething = true;
    }

    public boolean hasSomethingBeenDone() {
        return didSomething;
    }

}
