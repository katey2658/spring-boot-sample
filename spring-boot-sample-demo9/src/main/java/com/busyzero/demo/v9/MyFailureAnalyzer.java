package com.busyzero.demo.v9;

import org.springframework.boot.diagnostics.FailureAnalysis;
import org.springframework.boot.diagnostics.FailureAnalyzer;

public class MyFailureAnalyzer implements FailureAnalyzer {
    @Override
    public FailureAnalysis analyze(Throwable failure) {
        if (failure instanceof UnknownError) {
            return new FailureAnalysis("未知错误"," 请尝试重新启动", failure);
        }
        return null;
    }
}
