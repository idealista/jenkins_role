#!groovy
import jenkins.security.s2m.*
// https://wiki.jenkins-ci.org/display/JENKINS/Slave+To+Master+Access+Control
def instance = Jenkins.getInstance()
instance.injector.getInstance(AdminWhitelistRule.class).setMasterKillSwitch(false)
