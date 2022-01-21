package com.code.dora.algorithm;

/**
 * @author by 叶雪辉
 * @Date 2022/1/2 11:59
 * @Description
 */
public class MultiThreadPrint {
    private final Object lock = new Object();

    private static int state = 0;

    public static void main(String[] args) {
        new MultiThreadPrint().print();
    }

    private void print() {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();
        ThreadC threadC = new ThreadC();
        threadA.start();
        threadB.start();
        threadC.start();
    }

    class ThreadA extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10;) {
                try {
                    synchronized (lock) {
                        if (state % 3 == 0) {
                            System.out.print("A");
                            state++;
                            i++;
                            lock.notifyAll();
                        } else {
                            lock.wait();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }

    class ThreadB extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10;) {
                try {
                    synchronized (lock) {
                        if (state % 3 == 1) {
                            System.out.print("B");
                            state++;
                            i++;
                            lock.notifyAll();
                        } else {
                            lock.wait();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class ThreadC extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10;) {
                try {
                    synchronized (lock) {
                        if (state % 3 == 2) {
                            System.out.print("C");
                            state++;
                            i++;
                            lock.notifyAll();
                        } else {
                            lock.wait();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
