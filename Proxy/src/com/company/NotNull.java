package com.company;

import java.util.Objects;

public class NotNull {

    public static void newProxyInstance(String name) {
        Objects.requireNonNull(name);
        System.out.println(name);
    }
}
