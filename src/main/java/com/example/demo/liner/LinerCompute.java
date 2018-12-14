package com.example.demo.liner;

import org.springframework.util.CollectionUtils;

import java.util.List;

public class LinerCompute {

    public double getLinerRegression(double x, List<Double> xList, List<Double> yList) {
        double[] params = getLinerParam(xList, yList);
        return params[0] * x + params[1];
    }

    // 这是比较标准的线性回归的代码
    public double[] fittingParam(List<Double> xList, List<Double> yList){
        if (CollectionUtils.isEmpty(xList) || CollectionUtils.isEmpty(yList)) {
            throw new RuntimeException("线性回归聚合数据为空");
        }
        if (xList.size() != yList.size()) {
            throw new RuntimeException("线性回归聚合数据长度不一致。");
        }

        double[] params = new double[2];

        double sumX     = 0;
        double sumY     = 0;
        double sumXY    = 0;
        double sumX2    = 0;
        int    len      = xList.size();
        for(int i = 0; i < len; i++) {
            double x = xList.get(i);
            double y = yList.get(i);

            sumX += x;
            sumY += y;
            sumX2 += x * x;
            sumXY += x * y;
        }

        double paramA = (len * sumXY - sumX * sumY) / (len * sumX2 - sumX * sumX);
        double paramB = (sumY - paramA * sumX) / len ;

        params[0] = paramA;
        params[1] = paramB;
        return params;
    }

    public double[] getLinerParam(List<Double> xList, List<Double> yList) {
        if(CollectionUtils.isEmpty(xList) || CollectionUtils.isEmpty(yList)) {
            throw new RuntimeException("线性回归聚合数据为空");
        }
        if(xList.size() != yList.size()) {
            throw new RuntimeException("线性回归聚合数据长度不一致。");
        }

        double[] params = new double[2];
        double sumX     = 0;
        double sumY     = 0;
        double mutiXY   = 0;
        int    len      = xList.size();

        for(int i = 0; i < len ; i++) {
            sumX += xList.get(i);
            sumY += yList.get(i);
            mutiXY += xList.get(i) * yList.get(i);
        }

        double paramA = (mutiXY - len * (sumX/len) * (sumY/len)) / (sumX - len * (sumX/len));
        double paramB = (sumY / len) - paramA * (sumX / len);

        params[0] = paramA;
        params[1] = paramB;
        return params;
    }
}
