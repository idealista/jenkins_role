#!groovy
import hudson.security.csrf.DefaultCrumbIssuer

def instance = Jenkins.getInstance()
def crumb = null
if (${crumb_enabled}) {
    crumb = new DefaultCrumbIssuer(true)
}
instance.setCrumbIssuer(crumb)
instance.save()
