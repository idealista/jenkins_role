#!groovy
import com.cloudbees.jenkins.plugins.sshcredentials.impl.BasicSSHUserPrivateKey
import com.cloudbees.plugins.credentials.domains.Domain
import com.cloudbees.plugins.credentials.impl.*
import com.cloudbees.plugins.credentials.CredentialsScope
import com.cloudbees.plugins.credentials.SystemCredentialsProvider
import org.jenkinsci.plugins.plaincredentials.impl.StringCredentialsImpl
import hudson.util.Secret
import hudson.security.HudsonPrivateSecurityRealm
import jenkins.model.Jenkins

def ansible = new Domain("ansible", "ansible managed credentials", null)
SystemCredentialsProvider.getInstance().getStore().addDomain(ansible)

def credential = null
if ("${cred}" != "") {
    credential = new BasicSSHUserPrivateKey(
        CredentialsScope.GLOBAL,
        "${id}",
        "${username}",
        new BasicSSHUserPrivateKey.FileOnMasterPrivateKeySource("${cred}"),
        "${password}",
        "${description}")
} else if ("${text}" != "") {
    credential = new StringCredentialsImpl(
        CredentialsScope.GLOBAL,
        "${id}",
        "${description}",
        Secret.fromString("${text}"))
} else {
    credential = new UsernamePasswordCredentialsImpl(
        CredentialsScope.GLOBAL,
        "${id}",
        "${description}",
        "${username}",
        "${password}")
    if ("${security_enabled}" == "true") {
        def instance = Jenkins.getInstance()
        def hudsonRealm = new HudsonPrivateSecurityRealm(false)
        hudsonRealm.createAccount("${username}","${password}")
        instance.setSecurityRealm(hudsonRealm)
        instance.save()
    }
}

SystemCredentialsProvider.getInstance().getStore().addCredentials(ansible, credential)
