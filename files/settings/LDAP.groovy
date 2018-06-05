#!groovy
import jenkins.model.*
import hudson.security.*
import org.jenkinsci.plugins.*
import jenkins.security.plugins.ldap.*

SecurityRealm ldap_realm = new LDAPSecurityRealm(
                                    "${server}",
                                    "${rootDN}",
                                    "${userSearchBase}",
                                    "${userSearch}",
                                    "${groupSearchBase}",
                                    "${managerDN}",
                                    "${managerPassword}",
                                    ${inhibitInferRootDN})

Jenkins.instance.setSecurityRealm(ldap_realm)
Jenkins.instance.save()
