#!/bin/sh

echo "Start" >> /export/home/mpc/test.log
echo ${1} >> /export/home/mpc/test.log

if [ ! -f /opt/ESA/ESA/bin/fmsendmessage ];then
	exit 0
fi

. /var/opt/setup/site.export

REPORT_IP=${OAM_Center_Local_IP}
LOCAL_IP=${OAM_Center_Local_IP}
#if [ "X${OAM_Center_IP}" != "X" ];then
	#REPORT_IP=${OAM_Center_IP}
#fi

if [ "X${1}" = "Xraise" ];then
    /opt/ESA/ESA/bin/fmsendmessage -r OAMCenter 640 123 "OAM Center on ${LOCAL_IP} is down" ${REPORT_IP}
elif [ "X${1}" = "Xclear" ];then
	/opt/ESA/ESA/bin/fmsendmessage -c OAMCenter 640 123 "OAM Center on ${LOCAL_IP} is up" ${REPORT_IP}
elif [ "X${1}" = "Xstatus" ];then
    systemctl status oamcenter >> /export/home/mpc/test.log
    CHECK_EXIT=`systemctl status oamcenter | head -3 | grep '(Result: exit-code)'`

    systemctl status oamcenter  | head -3 | grep '(Result: exit-code)' >> /export/home/mpc/test.log
    if [[ $CHECK_EXIT =~ '(Result: exit-code)' ]];then
        echo "exit" >> /export/home/mpc/test.log
        exit 0
    fi
    CHECK_KILLED=`systemctl status oamcenter | head -3 | grep '(Result: signal)'`

    systemctl status oamcenter | head -3 | grep '(Result: signal)' >> /export/home/mpc/test.log
    if [[ $CHECK_KILLED =~ '(Result: signal)' ]];then
        echo "killed" >> /export/home/mpc/test.log
        /opt/ESA/ESA/bin/fmsendmessage -r OAMCenter 640 123 "OAM Center on ${LOCAL_IP} is down" ${REPORT_IP}
        exit 0
    fi
    CHECK_RESTART=`systemctl status oamcenter | head -3 | grep '(start-post)'`

    systemctl status oamcenter | head -3 | grep '(start-post)' >> /export/home/mpc/test.log
    if [[ $CHECK_RESTART =~ '(start-post)' ]];then
        echo "restart" >> /export/home/mpc/test.log
        /opt/ESA/ESA/bin/fmsendmessage -r OAMCenter 640 123 "OAM Center on ${LOCAL_IP} is down" ${REPORT_IP}
        exit 0
    fi
fi

echo "Stop\\n" >> /export/home/mpc/test.log
