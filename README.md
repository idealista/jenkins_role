![Logo](https://raw.githubusercontent.com/idealista/jenkins_role/master/logo.gif)

[![Build Status](https://travis-ci.org/idealista/jenkins_role.png)](https://travis-ci.org/idealista/jenkins_role)

# Jenkins Ansible role

Ansible role to install a Jenkins server in a Debian environment.

- [Getting Started](#getting-started)
    - [Prerequisities](#prerequisities)
    - [Installing](#installing)
- [Usage](#usage)
- [Testing](#testing)
- [Built With](#built-with)
- [Versioning](#versioning)
- [Authors](#authors)
- [License](#license)
- [Contributing](#contributing)

## Getting Started

These instructions will get you a copy of the role for your Ansible Playbook. Once launched, it will install a [Jenkins](https://jenkins.io/) server in a Debian system.

### Prerequisities

Ansible 2.9.14 version installed.
Inventory destination should be a Debian environment.

For testing purposes, [Molecule](https://molecule.readthedocs.io/) with [Docker](https://www.docker.com/) as driver.

### Installing

Create or add to your roles dependency file (e.g requirements.yml) from GitHub:

```
- src: http://github.com/idealista/jenkins_role.git
  scm: git
  version: 1.0.0
  name: jenkins
```

or using [Ansible Galaxy](https://galaxy.ansible.com/idealista/jenkins_role/) as origin if you prefer:

```
- src: idealista.jenkins_role
  version: 1.0.0
  name: jenkins
```

Install the role with ansible-galaxy command:

```
ansible-galaxy install -p roles -r requirements.yml -f
```

Use in a playbook:

```
---
- hosts: someserver
  roles:
    - jenkins
```

## Usage

Look to the [defaults](defaults/main.yml) properties file to see the possible configuration properties.

## Testing

### Install dependencies

```sh
pipenv sync
pipenv shell
```

For more information read the [pipenv docs](https://docs.pipenv.org/).

### Running test

```
molecule test
```

See molecule/molecule.yml to check possible testing platforms.

## Built With

![Ansible](https://img.shields.io/badge/ansible-2.9.14-green.svg)

## Versioning

For the versions available, see the [tags on this repository](https://github.com/idealista/jenkins_role/tags).

Additionaly you can see what change in each version in the [CHANGELOG.md](CHANGELOG.md) file.

## Authors

* **Idealista** - *Work with* - [idealista](https://github.com/idealista)

See also the list of [contributors](https://github.com/idealista/jenkins_role/contributors) who participated in this project.

## License

![Apache 2.0 Licence](https://img.shields.io/hexpm/l/plug.svg)

This project is licensed under the [Apache 2.0](https://www.apache.org/licenses/LICENSE-2.0) license - see the [LICENSE](LICENSE) file for details.

## Contributing

Please read [CONTRIBUTING.md](.github/CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests to us.
