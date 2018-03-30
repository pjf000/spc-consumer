package com.test.spc.utils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by JeffPeng on 2018/3/30.
 */
public class TestUtil {

    public static void main(String args[]){
        System.out.println("——————————————————————————————");
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        filter(features,(s)->s.endsWith("I"));
    }
    public static void filter(List<String> names, Predicate<String> condition) {
        names.stream().filter((name) -> (condition.test(name))).forEach((name) -> {
            System.out.println(name + " ");
        });
    }
}
