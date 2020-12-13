#include <jni.h>
#include <string>

extern "C" JNIEXPORT jint JNICALL
Java_id_ac_ui_cs_mobileprogramming_RahmadianTioPratama_helloworld_MainActivity_penjumlahanFromJNI(
        JNIEnv *env,
        jobject /* this */,
        jint x,
        jint y) {
        return x+y;
}