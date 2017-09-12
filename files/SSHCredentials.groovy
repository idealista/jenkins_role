import com.cloudbees.jenkins.plugins.sshcredentials.impl.BasicSSHUserPrivateKey
import com.cloudbees.plugins.credentials.domains.Domain
import com.cloudbees.plugins.credentials.impl.UsernamePasswordCredentialsImpl
import com.cloudbees.plugins.credentials.CredentialsScope
import com.cloudbees.plugins.credentials.SystemCredentialsProvider

def ansible = new Domain("ansible", "ansible managed credentials", null)
SystemCredentialsProvider.getInstance().getStore().addDomain(ansible)

def credential = new BasicSSHUserPrivateKey(CredentialsScope.GLOBAL, 'jenkins', 'jenkins', new BasicSSHUserPrivateKey.UsersPrivateKeySource(), '', 'jenkins master certificate')
SystemCredentialsProvider.getInstance().getStore().addCredentials(ansible, credential)
