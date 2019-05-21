package com.example.testpractice.asm;

import jdk.internal.org.objectweb.asm.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class AsmDemo extends ClassLoader {
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException, InvocationTargetException {
        ClassReader classReader = new ClassReader("com.example.testpractice.asm.Demo");
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        CustomVisitor customVisitor =new CustomVisitor(Opcodes.ASM4, classWriter);
        classReader.accept(customVisitor, 0);
        byte[] code = classWriter.toByteArray();

        AsmDemo loader = new AsmDemo();
        Class<?> appClass = loader.defineClass(null, code, 0,code.length);
        appClass.getMethods()[0].invoke(appClass.newInstance());
    }
}

class CustomVisitor extends ClassVisitor implements Opcodes {

    public CustomVisitor(int i, ClassVisitor classVisitor) {
        super(i, classVisitor);
    }

    @Override
    public MethodVisitor visitMethod(int i, String s, String s1, String s2, String[] strings) {
        MethodVisitor methodVisitor = super.visitMethod(i, s, s1, s2, strings);
        methodVisitor.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        methodVisitor.visitLdcInsn("Hello World!");
        methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V");
        return methodVisitor;
    }
}


