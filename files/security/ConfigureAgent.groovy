#!groovy
/*
   Copyright (c) 2015-2018 Sam Gleske - https://github.com/samrocketman/jenkins-bootstrap-shared
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
       http://www.apache.org/licenses/LICENSE-2.0
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
   */
/*
   Disable all JNLP protocols except for JNLP4.  JNLP4 is the most secure agent
   protocol because it is using standard TLS.
 */
import jenkins.model.Jenkins
import java.util.logging.Level
import java.util.logging.Logger

Logger logger = Logger.getLogger('jenkins.instance.configAgent')

Set<String> agentProtocolsList = ['JNLP4-connect', 'Ping']
if(!Jenkins.instance.getAgentProtocols().equals(agentProtocolsList)) {
    Jenkins.instance.setAgentProtocols(agentProtocolsList)
    logger.log(Level.INFO, "Agent Protocols have changed.  Setting: ${agentProtocolsList}")
    Jenkins.instance.save()
}
else {
    logger.log(Level.INFO, "Nothing changed.  Agent Protocols already configured: ${Jenkins.instance.getAgentProtocols()}")
}
