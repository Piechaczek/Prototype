package com.example.droolsprototype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Timer;

/**
 * Application entry point
 */
@SpringBootApplication
public class DroolsPrototypeApplication {

    public final static double CPU_THRESHOLD = 10.0;

    private final DemoTask demoTask;

    public static void main(String[] args) {
        //create an instance of this class and all its dependencies
        ConfigurableApplicationContext context = SpringApplication.run(DroolsPrototypeApplication.class, args);
        //get the instance and invoke the runExample() method
        context.getBean(DroolsPrototypeApplication.class).runExample();
    }

    public DroolsPrototypeApplication(DemoTask demoTask) {
        this.demoTask = demoTask;
    }

    public void runExample() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(demoTask, 0, 10000); //run demo every 10 seconds

        //Michał code:
//        try {
//            File myObj = new File("../metrics/new.txt");
//            FileWriter myWriter = new FileWriter("../metrics/new.txt");
//            myWriter.write("aaaaa");
//            myWriter.close();
//
//            File myObj2 = new File("new.txt");
//            FileWriter myWriter2 = new FileWriter("new.txt");
//            myWriter2.write("bbbbb");
//            myWriter2.close();
//
//            if (myObj.createNewFile()) {
//                System.out.println("File created: " + myObj.getName());
//            } else {
//                System.out.println("File already exists.");
//            }
//            if (myObj2.createNewFile()) {
//                System.out.println("File created: " + myObj2.getName());
//            } else {
//                System.out.println("File already exists.");
//            }
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//        while (true) {
//            try {
//                QueryResult queryResult = queryService.queryMetric("container_start_time_seconds{container=\\\"rabbitmq-8d7575749-6dx6x\\\"}");
//                System.out.println(queryResult);
//                Metric metric = new Metric("time", "rabbitmq-8d7575749-6dx6x", queryResult);
//
////                debug
//                System.out.println(metric);
//
////                give control of these objects to the drools engine
//                kieSession.insert(metric);
//                kieSession.insert(executionService);
//
////                tell drools to evaluate all rules
//                System.out.println("Running drools...");
//                kieSession.fireAllRules();
//
////                debug
//                System.out.println("Example over");
//
//            }
//            catch(Exception e){
//                System.out.println(e);
//                Thread.sleep(10000);
//            }
//        }
    }


}
