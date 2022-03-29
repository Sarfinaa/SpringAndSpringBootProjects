package main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import repository.WorkerRepository;
import model.Worker;
import java.util.Date;
import helpers.WorkerHelper;
public class Main {
    public static void main(String[] args) throws Exception {
        @SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        WorkerRepository workerRepository = (WorkerRepository) context.getBean("workerRepository");
        Worker worker = new Worker(9, "karan", "k.seth@my_org.in");
        System.out.println(workerRepository.add(worker) + " row is added!!!");
        Worker emp = new Worker(9, "Karan", "Seth", 50000, new Date(), "new",
                "k.seth1r@my_org.in");
        workerRepository.update(emp);
        List<Worker> workers = workerRepository.getWorkers();
        System.out.println("---------Printing Workers Data-----------");
       WorkerHelper.printAllWorkers(workers);
       System.out.println("------------------------------------------");
       System.out.println("Get row with workerId 1");
        System.out.println(workerRepository.getWorker(1));
        System.out.println("------------------------------------------");

        workerRepository.delete(9);

    }
}
