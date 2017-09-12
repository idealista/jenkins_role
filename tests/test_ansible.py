import pytest
import requests


@pytest.fixture()
def AnsibleDefaults(Ansible):
    return Ansible("include_vars", "defaults/main.yml")["ansible_facts"]


@pytest.fixture()
def AnsibleVars(Ansible):
    return Ansible("include_vars", "tests/group_vars/test01.yml")["ansible_facts"]


@pytest.fixture()
def Hostname(TestinfraBackend):
    return TestinfraBackend.get_hostname()


def test_jenkins_service(Service, Socket, AnsibleDefaults, Hostname):
    if Hostname in ("jenkins-master.vm"):
        port = AnsibleDefaults["jenkins_port"]
        assert Service("jenkins").is_enabled
        assert Service("jenkins").is_running
        assert Socket("tcp://0.0.0.0:{0}".format(port)).is_listening


def test_jenkins_version(AnsibleDefaults, Hostname):
    if Hostname in ("jenkins-master.vm"):
        port = AnsibleDefaults["jenkins_port"]
        request = requests.get('http://' + Hostname + ':' + format(port))
        installed_version = request.headers['X-Jenkins']
        desired_version = AnsibleDefaults["jenkins_version"]
        assert desired_version == installed_version
