

export GOOGLE_APPLICATION_CREDENTIALS=/home/solon_j_t_xu/key/dmlusr.json

#echo "$GOOGLE_APPLICATION_CREDENTIALS"

APP_DIR="/home/solon_j_t_xu/app/om-mockup-ws"

LIB_DIR=${APP_DIR}/lib
CONFIG_DIR=${APP_DIR}/config


CLASSS_PATH=


GET_LIB()
{
  for file in $1/*; do
    if [ -d $file ] 
    then
      GET_LIB $file
    else 
      CLASS_PATH=$CLASS_PATH:$file
    fi
  done

}


GET_LIB $LIB_DIR

CLASS_PATH=$CLASS_PATH:$CONFIG_DIR


echo "the classpath is $CLASS_PATH"


JVM_OPTION="-Djava.security.egd=file:/dev/urandom"

MAIN_CLASS="com.maplequad.gbm.grt.om.bootstrap.WsApplication"

java $JVM_OPTION -cp $CLASS_PATH $MAIN_CLASS



