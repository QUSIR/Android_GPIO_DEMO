LOCAL_PATH := $(call my-dir)

NDK_PATH := D:\android-ndk-r14b
include $(CLEAR_VARS)
LOCAL_MODULE    := gpio_jni
LOCAL_LDLIBS += -L$(SYSROOT)/usr/lib -llog
LOCAL_LDLIBS += "-L$(NDK_PATH)/platforms/android-22/arch-arm/usr/lib" -lc -lgcc -lOpenSLES -llog -lGLESv2 -lEGL -landroid
LOCAL_SRC_FILES += Gpiolib.cpp
LOCAL_ARM_MODE := arm
include $(BUILD_SHARED_LIBRARY)