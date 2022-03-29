package helpers;
import java.util.List;
import model.Worker;
public class WorkerHelper {
	public static void printAllWorkers(List<Worker> workers) {
		for(Worker worker: workers) {
System.out.println(worker);
		}
	}
}