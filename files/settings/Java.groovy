#!groovy
import hudson.model.*
import hudson.tools.*
import jenkins.*
import jenkins.model.*
import java.util.logging.Level
import java.util.logging.Logger

Logger logger = Logger.getLogger('jenkins.instance.settings.java')

def jdkDescriptor = Jenkins.getInstance().getDescriptor("hudson.model.JDK")
def jdkInstallerDescriptor = Jenkins.getInstance().getDescriptor("hudson.tools.JDKInstaller")

def installations = Jenkins.getInstance().getJDKs()
def exists = false

def jdkName = "java${version}-${implementation}"

installations.find{ jdk ->
  if (jdk.getName() == jdkName) {
    logger.log(Level.INFO, jdk.getName() + " already exists")
    exists = true
    return true
  }
  return false
}
if (exists) {
  return
}

if ("${implementation}" == "openjdk") {
  installations.push(new JDK(jdkName, "${home}"))
} else if ("${implementation}" == "oraclejdk") {
  def installer = new JDKInstaller("${install}", true)
  def installerProps = new InstallSourceProperty([installer])
  installations.push(new JDK(jdkName, null, [installerProps]))
  jdkInstallerDescriptor.doPostCredential("${user}", "${password}")
}

jdkDescriptor.setInstallations(installations.toArray(new JDK[0]))
