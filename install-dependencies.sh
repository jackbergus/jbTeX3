#!/bin/sh
mkdir -p dependencies
cd dependencies
echo "Type the OracleDB username [ENTER]:"
read user
echo "Type the OracleDB password [ENTER]:"
read pass
wget --user $user --password $pass http://download.oracle.com/otn/other/bigdata/oxh-4.9.0-cdh5.0.0.zip
unzip oxh-4.9.0-cdh5.0.0.zip
xqj_dir=oxh-4.9.0-cdh5.0.0/hive/lib/

mvn install:install-file \
   -Dfile=${xqj_dir}/oxquery.jar \
   -DgroupId=com.oracle.xqj \
   -DartifactId=oxquery \
   -Dversion=0.1 \
   -Dpackaging=jar \
   -DgeneratePom=true

mvn install:install-file \
   -Dfile=${xqj_dir}/xqjapi.jar \
   -DgroupId=com.oracle.xqj \
   -DartifactId=xqjapi \
   -Dversion=0.1 \
   -Dpackaging=jar \
   -DgeneratePom=true

mvn install:install-file \
   -Dfile=${xqj_dir}/orai18n-mapping.jar \
   -DgroupId=com.oracle.xqj \
   -DartifactId=orai18n-mapping \
   -Dversion=0.1 \
   -Dpackaging=jar \
   -DgeneratePom=true

mvn install:install-file \
   -Dfile=${xqj_dir}/xmlparserv2_sans_jaxp_services.jar \
   -DgroupId=com.oracle.xqj \
   -DartifactId=xmlparserv2 \
   -Dversion=0.1 \
   -Dpackaging=jar \
   -DgeneratePom=true

mvn install:install-file \
   -Dfile=${xqj_dir}/apache-xmlbeans.jar \
   -DgroupId=com.oracle.xqj \
   -DartifactId=apache-xmlbeans \
   -Dversion=0.1 \
   -Dpackaging=jar \
   -DgeneratePom=true