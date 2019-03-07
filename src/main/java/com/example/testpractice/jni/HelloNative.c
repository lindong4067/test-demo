#include <stdio.h>

#include "HelloNative.h"

JNIEXPORT void JNICALL Java_com_example_testpractice_jni_HelloNative_sayHello(JNIEnv *, jclass)
{
    printf("Hello Native\n");
}