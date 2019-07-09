import jenkins.plugins.nodejs.tools.*
import jenkins.model.*
import hudson.tools.*

def inst = Jenkins.getInstance()
def desc = inst.getDescriptor("jenkins.plugins.nodejs.tools.NodeJSInstallation")

def sinst = []

{% for node in versions %}
installer = new NodeJSInstaller("{{ node.version }}", "{{ node.pkgs }}", {{ node.refresh }})
prop = new InstallSourceProperty([installer])
sinst << new NodeJSInstallation("NodeJS_{{ node.name }}", "", [prop])
{% endfor %}

desc.setInstallations(*sinst)
desc.save()
