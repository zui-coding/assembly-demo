#!/bin/bash
echo "start server...."

BIN_DIR=$(dirname $0)
cd ${BIN_DIR}
echo "bin_dir => ${BIN_DIR}"
DEPLOYE_DIR=`dirname ../${BIN_DIR}`
echo "--> $DEPLOYE_DIR"
BIN_DIR=${DEPLOYE_DIR}/bin
echo "--> $BIN_DIR"
CONF_DIR=$DEPLOYE_DIR/conf
echo "--> $CONF_DIR"
LIB_DIR=$DEPLOYE_DIR/lib
echo "--> $LIB_DIR"

RUN_JAVA_CMD="$JAVA_HOME/bin/java"

LIB_JARS=$(ls  $LIB_DIR|grep ".jar" | awk '{print "'$LIB_DIR'/"$1}' | tr "\n" ":")
echo "--> $LIB_JARS"
JAVA_CP="-classpath $CONF_DIR:$LIB_JARS"
echo "--> $JAVA_CP"

$RUN_JAVA_CMD $JAVA_CP com.zuicoding.platform.Application
