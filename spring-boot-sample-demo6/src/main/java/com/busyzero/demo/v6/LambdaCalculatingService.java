package com.busyzero.demo.v6;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Stream;

@Service
@Profile("Java8")
public class LambdaCalculatingService implements CalculatingService {

    @Override
    public Integer sum(Integer... values) {
        int sum = Stream.of(values).reduce(0, Integer::sum);
        System.out.printf("[java8 lambda 实现] %s 累加结果是: %d\n", Arrays.asList(values), sum);
        return sum;
    }
}
