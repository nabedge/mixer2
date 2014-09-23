#!/bin/sh
sudo yum -y install git gcc-c++ fuse fuse-devel libcurl-devel libxml2-devel openssl-devel
wget https://s3fs.googlecode.com/files/s3fs-1.74.tar.gz
tar xf s3fs-1.74.tar.gz
cd s3fs-1.74
./configure
make
sudo make install
sudo mkdir /mnt/mixer2.org
sudo chmod 777 /mnt/mixer2.org
sudo /usr/local/bin/s3fs mixer2.org /mnt/mixer2.org -o allow_other -o default_acl=public-read
ls -l /mnt/mixer2.org
ls -l ~/

