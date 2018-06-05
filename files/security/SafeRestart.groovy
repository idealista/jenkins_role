#!groovy
import hudson.model.RestartListener
import java.util.logging.Level
import java.util.logging.Logger

//user configurable variable
if(!binding.hasVariable('timeout_seconds')) {
    timeout_seconds = 10
}

if(timeout_seconds in String) {
    timeout_seconds = Integer.decode(timeout_seconds)
}

//type check user defined parameters/bindings
if(!(timeout_seconds in Integer)) {
    throw new Exception('PARAMETER ERROR: timeout_seconds must be an integer.')
}

Logger logger = Logger.getLogger('jenkins.instance.restart')

//start a background thread
def thread = Thread.start {
    logger.log(Level.INFO, "Jenkins safe restart initiated.")
    while(true) {
        if (!Jenkins.instance.isQuietingDown()) {
            logger.log(Level.INFO, "Shutdown mode not enabled.  Jenkins restart aborted.")
            break
        }
        if(RestartListener.isAllReady()) {
            Jenkins.instance.restart()
        }
        logger.log(Level.INFO, "Jenkins jobs are not idle.  Waiting ${timeout_seconds} seconds before next restart attempt.")
        sleep(timeout_seconds*1000)
    }
}

println 'A safe restart has been scheduled.  See the Jenkins logs for restart status updates.  Logger is jenkins.instance.restart.'
