#!groovy
import hudson.plugins.groovy.*
import jenkins.model.*
import hudson.tools.*
import java.util.logging.Level
import java.util.logging.Logger

Logger logger = Logger.getLogger('jenkins.instance.settings.groovy')

def desc = Jenkins.getInstance().getDescriptor("hudson.plugins.groovy.GroovyInstallation")

def prev = Jenkins.getInstance().getDescriptorByType(Groovy.DescriptorImpl.class).getInstallations()
def exists = false

def groovyName = "Groovy_${version}"
def installations = []

prev.each{ groovy ->
  if (groovy.getName() == groovyName) {
    logger.log(Level.INFO, groovy.getName() + " already exists")
    exists = true
  }
  installations.push(groovy)
}
if (exists) {
  return
}

def installer = new GroovyInstaller("${version}")
def prop = new InstallSourceProperty([installer])
installations.add(new GroovyInstallation(groovyName, "", [prop]))
desc.setInstallations(*installations)
