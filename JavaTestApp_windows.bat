@echo off

java -classpath "dist;dist/lib;dist/JavaTestApp.jar" -Dsun.java2d.noddraw=true -Djava.library.path="dist;dist/lib/windows;dist/JavaTestApp.jar" com.bianisoft.tests.javatestapp.AppJavaTest
