package com.busyzero.demo.v6;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@Profile("Java7")
public class IterationCalculatingService implements CalculatingService {
    @Override
    public Integer sum(Integer... values) {
        int sum = 0;
        for (Integer val : values) {
            sum += val;
        }
        System.out.printf("[java7 迭代实现] %s 累加结果是: %d\n", Arrays.asList(values), sum);
        return sum;
    }
}
