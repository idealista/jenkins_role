#!groovy
import hudson.plugins.groovy.*
import hudson.tools.InstallSourceProperty
import java.util.logging.Level
import java.util.logging.Logger

Logger logger = Logger.getLogger('jenkins.instance.settings.groovy')
def groovyPlugin = Jenkins.getInstance().getExtensionList(hudson.plugins.groovy.Groovy.DescriptorImpl.class)[0]

def groovyName = "Groovy_${version}"

def groovyInstall = groovyPlugin.installations.find {
  install -> install.name.equals(groovyName)
}

if (groovyInstall != null) {
  logger.log(Level.INFO, groovyName + " already exists")
  return
}

def installer = new GroovyInstaller("${version}")
def prop = new InstallSourceProperty([installer])
groovyPlugin.installations += new GroovyInstallation(groovyName, null, [prop])
groovyPlugin.save()
