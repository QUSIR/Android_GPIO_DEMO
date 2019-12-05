#include <jni.h>
#include <string>

#include <unistd.h>
#include"Logger.h"
#include <stdio.h>
#include <linux/input.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

#define DEV_PATH "/sys/class/gpio_sw/PE12/data"   //difference is possible


extern "C"
JNIEXPORT jint JNICALL
Java_com_gpio_demo_GpioJni_SetGpio(JNIEnv *env, jobject thiz) {
    // TODO: implement SetGpio()
    int fd;
    fd = open(DEV_PATH, O_WRONLY);
    if(fd < 0){
        LOGE("fail in open file %s", DEV_PATH);
        return -1;
    }
    write(fd, "1", strlen("1"));
    sleep(1);
    write(fd, "0", strlen("0"));
    close(fd);
    return 0;
}