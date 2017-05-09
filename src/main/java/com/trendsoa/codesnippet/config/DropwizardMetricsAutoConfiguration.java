package com.trendsoa.codesnippet.config;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.jvm.MemoryUsageGaugeSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * add JVM metrics: heap, non-heap(metaspace, code cache, compressed class point)
 * Created by jeszhang on 07-05-2017.
 */
@Configuration
@ConditionalOnClass({MetricRegistry.class, MemoryUsageGaugeSet.class})
public class DropwizardMetricsAutoConfiguration {

    @Autowired
    private MetricRegistry metricRegistry;

    @PostConstruct
    public void addJvmMetrics() {

        metricRegistry.register("jvm.mem", new MemoryUsageGaugeSet());

    }
}
