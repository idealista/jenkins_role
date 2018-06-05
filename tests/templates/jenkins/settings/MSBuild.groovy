import hudson.plugins.msbuild.*
import hudson.plugins.sonar.*

def runner_Inst = jenkins.model.Jenkins.getInstance()
def runner_Desc = runner_Inst.getDescriptor("hudson.plugins.msbuild.MsBuildBuilder")

def sinst = []

{% for build in versions %}
sinst << new MsBuildInstallation("{{ build.name }}", "{{ build.path }}", "{{ build.params }}")
{% endfor %}

runner_Desc.setInstallations(*sinst)
runner_Desc.save()
