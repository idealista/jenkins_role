# Change Log
All notable changes to this project will be documented in this file.
This project adheres to [Semantic Versioning](http://semver.org/) and [Keep a changelog](https://github.com/olivierlacan/keep-a-changelog).

## [Unreleased](https://github.com/idealista/jenkins_role/tree/develop)
### Added
- *[#48] Support for jenkins v2.249.2.* @vicsufer
- *[#48] Add session cookie for API Requests* @vicsufer
### Changed
- *[#48] Disable CLI with java argument-* @vicsufer


## [2.5.0](https://github.com/idealista/jenkins_role/tree/2.5.0)
## [Full Changelog](https://github.com/idealista/jenkins_role/compare/2.4.0...2.5.0)
- *[#49] Add adoptopenjdk support* @vicsufer

## [2.4.0](https://github.com/idealista/jenkins_role/tree/2.4.0)
## [Full Changelog](https://github.com/idealista/jenkins_role/compare/2.3.0...2.4.0)
### Added
- *[#40] JVM args in slaves* @sorobon

## [2.3.0](https://github.com/idealista/jenkins_role/tree/2.3.0)
## [Full Changelog](https://github.com/idealista/jenkins_role/compare/2.2.0...2.3.0)
### Changed
- *Migrate molecule tests to Docker containers* @miguel-chacon
- *Upgrade Ansible and Molecule versions* @miguel-chacon
- *Upgrade to Python 3* @miguel-chacon

## [2.2.0](https://github.com/idealista/jenkins_role/tree/2.2.0)
## [Full Changelog](https://github.com/idealista/jenkins_role/compare/2.1.0...2.2.0)
### Changed
- *Allow change dslJob.xml file via variable* @amanzanotejon

## [2.1.0](https://github.com/idealista/jenkins_role/tree/2.1.0)
## [Full Changelog](https://github.com/idealista/jenkins_role/compare/2.0.1...2.1.0)
### Changed
- *Jenkins default version 2.138.1* @jnogol
- *Install jdk-tool plugin by default* @jnogol

## [2.0.1](https://github.com/idealista/jenkins_role/tree/2.0.1)
## [Full Changelog](https://github.com/idealista/jenkins_role/compare/2.0.0...2.0.1)
### Fixed
- *Disabled script security by default* @jmonterrubio
- *[#17](https://github.com/idealista/jenkins_role/issues/17) Fix broken securityRealm if security enabled and no LDAP used* @jmonterrubio

## [2.0.0](https://github.com/idealista/jenkins_role/tree/2.0.0)
## [Full Changelog](https://github.com/idealista/jenkins_role/compare/1.2.0...2.0.0)
### Changed
- *Install default plugins* @jmonterrubio
- *Install default settings* @jmonterrubio
- *Remove CLI* @jmonterrubio

### Added
- *Improve security* @jmonterrubio
- *Job DSL execution* @jmonterrubio


## [1.2.0](https://github.com/idealista/jenkins_role/tree/1.2.0)
## [Full Changelog](https://github.com/idealista/jenkins_role/compare/1.1.0...1.2.0)
### Changed
- *[#11](https://github.com/idealista/jenkins_role/issues/11) Conditional execution of slave.yml* @jnogol

### Fixed
- *[#4](https://github.com/idealista/jenkins_role/issues/4) Travis test working* @jnogol
- *[#10](https://github.com/idealista/jenkins_role/issues/10) Jenkins_plugin with Ansible 2.4.x* @jnogol

## [1.1.0](https://github.com/idealista/jenkins_role/tree/1.1.0)
## [Full Changelog](https://github.com/idealista/jenkins_role/compare/1.0.0...1.1.0)
### Changed
- *[#2](https://github.com/idealista/jenkins_role/issues/2) Now scripts are executed via `jenkins_script` module* @jnogol
- *[#5](https://github.com/idealista/jenkins_role/issues/5) Plugins are installed via `jenkins_plugin` module* @jnogol

### Added
- *Added contribution guide by @jmonterrubio* @jnogol

## [1.0.0](https://github.com/idealista/jenkins_role/tree/1.0.0) (2017-09-12)
### Added
- *First release*
