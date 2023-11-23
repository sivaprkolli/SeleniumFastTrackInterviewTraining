package Abstraction;

import Constructor.ProtectedTestA;

public class ProtectedTestB extends ProtectedTestA {

    public static void main(String[] args) {
        ProtectedTestB protectedA = new ProtectedTestB();
        protectedA.testA();
    }
}
