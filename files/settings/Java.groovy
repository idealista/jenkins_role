#!groovy
import hudson.model.*
import hudson.tools.*
import jenkins.*
import jenkins.model.*
import java.util.logging.Level
import java.util.logging.Logger

Logger logger = Logger.getLogger('jenkins.instance.settings.java')

def javaPlugin = Jenkins.getInstance().getExtensionList(hudson.model.JDK.DescriptorImpl.class)[0]
def jdkInstallerDescriptor = Jenkins.getInstance().getDescriptor("hudson.tools.JDKInstaller")
def jdks = Jenkins.getInstance().getJDKs()
def jdkName = "java${version}-${implementation}"

def javaInstall = javaPlugin.installations.find {
  install -> install.name.equals(jdkName)
}

if (javaInstall != null) {
  logger.log(Level.INFO, jdkName + " already exists")
  return
}

if ("${implementation}" == "openjdk") {
  jdks.push(new JDK(jdkName, "${home}"))
} else if ("${implementation}" == "oraclejdk") {
  def installer = new JDKInstaller("${install}", true)
  def installerProps = new InstallSourceProperty([installer])
  jdks.push(new JDK(jdkName, null, [installerProps]))
  jdkInstallerDescriptor.doPostCredential("${user}", "${password}")
}
