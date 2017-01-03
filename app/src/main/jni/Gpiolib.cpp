//
// Created by liang on 2016/7/7.
//

#include"com_example_liang_gpio_demo_Gpio.h"

#include <unistd.h>
#include"Logger.h"
#include <stdio.h>
#include <linux/input.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

#define DEV_PATH "/sys/class/gpio_sw/PE12/data"   //difference is possible


JNIEXPORT jint JNICALL Java_com_example_liang_gpio_1demo_Gpio_Set_1GPIO
        (JNIEnv *env,jobject){
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
