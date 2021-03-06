

export GOOGLE_APPLICATION_CREDENTIALS=/home/solon_j_t_xu/key/dmlusr.json

echo "$GOOGLE_APPLICATION_CREDENTIALS"

APP_DIR="/home/solon_j_t_xu/app/spring-cloud"

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

JVM_OPTION=
APP_OPTION="$*"

MAIN_CLASS="org.foundation.dml.util.GSFileUtil"

CMD="java $JVM_OPTION -cp $CLASS_PATH $MAIN_CLASS $APP_OPTION"

echo "$CMD"

eval $CMD



