#!/bin/sh

PUPPET_DIR=/etc/puppet
mkdir -p $PUPPET_DIR/modules

apt-get install -y puppet
puppet module install puppetlabs/postgresql
cp /vagrant/puppet/Puppetfile $PUPPET_DIR
