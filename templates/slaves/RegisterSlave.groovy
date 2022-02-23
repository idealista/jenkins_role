#!groovy
import jenkins.security.s2m.*
import hudson.plugins.sshslaves.SSHLauncher
import hudson.slaves.DumbSlave
import hudson.slaves.RetentionStrategy

def instance = Jenkins.getInstance()

instance.addNode(new DumbSlave(
                "${name}",
                "${description}",
                "${home}",
                "${executors}",
                Node.Mode.EXCLUSIVE,
                "${label}",
                new SSHLauncher("${hostname}", 22, "${credentials}", "{{ item.vmargs | default('') }}", "{{ item.javaPath | default('') }}", "", "", 0, 3, 5, null),
                new RetentionStrategy.Always(),
                new LinkedList()
                ))

instance.save()
