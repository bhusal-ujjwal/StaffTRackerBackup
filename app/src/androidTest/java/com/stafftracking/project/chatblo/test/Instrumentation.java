package com.stafftracking.project.chatblo.test;//package com.stafftracking.project.chatblo.test;
//
//import android.os.Bundle;
//import androidx.test.runner.MonitoringInstrumentation;
//import com.stafftracking.project.chatblo.BuildConfig;
//import cucumber.api.CucumberOptions;
//import cucumber.api.android.CucumberInstrumentationCore;
//
//
//@CucumberOptions(
//        features = "features",
//        glue = "com.stafftracking.project.chatblo.test")
//public class Instrumentation extends MonitoringInstrumentation {
//
//    private final CucumberInstrumentationCore instrumentationCore = new CucumberInstrumentationCore(this);
//
//    @Override
//    public void onCreate(Bundle arguments) {
//        super.onCreate(arguments);
//
//        String tags = BuildConfig.TEST_TAGS;
//        if (!tags.isEmpty()) {
//            arguments.putString("tags", tags.replaceAll(",", "--").replaceAll("\\s",""));
//        }
//
//        instrumentationCore.create(arguments);
//        start();
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//
//        waitForIdleSync();
//        instrumentationCore.start();
//    }
//}
