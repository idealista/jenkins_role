#!groovy
import hudson.tools.InstallSourceProperty
import hudson.tasks.Maven.MavenInstallation
import hudson.tasks.Maven.MavenInstaller
import java.util.logging.Level
import java.util.logging.Logger

Logger logger = Logger.getLogger('jenkins.instance.settings.maven')
def mavenPlugin = Jenkins.getInstance().getExtensionList(hudson.tasks.Maven.DescriptorImpl.class)[0]

def mavenName = "Maven_${version}"

def mavenInstall = mavenPlugin.installations.find {
  install -> install.name.equals(mavenName)
}

if (mavenInstall != null) {
  logger.log(Level.INFO, mavenName + " already exists")
  return
}

def installer = new MavenInstaller("${version}")
def prop = new InstallSourceProperty([installer])
mavenPlugin.installations += new MavenInstallation(mavenName, null, [prop])
mavenPlugin.save()
