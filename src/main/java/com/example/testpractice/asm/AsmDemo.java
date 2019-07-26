package com.example.testpractice.asm;

import org.objectweb.asm.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class AsmDemo extends ClassLoader {
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException, InvocationTargetException {
        ClassReader classReader = new ClassReader("com.example.testpractice.asm.Demo");
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        CustomVisitor customVisitor =new CustomVisitor(Opcodes.AALOAD, classWriter);
        classReader.accept(customVisitor, 0);
        byte[] code = classWriter.toByteArray();

        AsmDemo loader = new AsmDemo();
        Class<?> appClass = loader.defineClass(null, code, 0,code.length);
        appClass.getMethods()[0].invoke(appClass.newInstance());
    }
}

class CustomVisitor implements Opcodes, ClassVisitor {

    public CustomVisitor(int i, ClassVisitor classVisitor) {
//        super(i, classVisitor);
    }

    @Override
    public void visit(int i, int i1, String s, String s1, String s2, String[] strings) {

    }

    @Override
    public void visitSource(String s, String s1) {

    }

    @Override
    public void visitOuterClass(String s, String s1, String s2) {

    }

    @Override
    public AnnotationVisitor visitAnnotation(String s, boolean b) {
        return null;
    }

    @Override
    public void visitAttribute(Attribute attribute) {

    }

    @Override
    public void visitInnerClass(String s, String s1, String s2, int i) {

    }

    @Override
    public FieldVisitor visitField(int i, String s, String s1, String s2, Object o) {
        return null;
    }

    @Override
    public MethodVisitor visitMethod(int i, String s, String s1, String s2, String[] strings) {
        MethodVisitor methodVisitor = visitMethod(i, s, s1, s2, strings);
        methodVisitor.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        methodVisitor.visitLdcInsn("Hello World!");
        methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V");
        return methodVisitor;
    }

    @Override
    public void visitEnd() {

    }
}


