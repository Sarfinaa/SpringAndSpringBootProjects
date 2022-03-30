package repository;

import java.util.Date;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import model.Worker;
import dao.WorkerDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import mapper.WorkerMapper;

public class WorkerRepository implements WorkerDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public int add(Worker worker) throws SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String joiningDate = sdf.format(worker.getJoiningDate());
        String query = "INSERT INTO worker VALUES(?,?,?,?,?,?,?)";
        return jdbcTemplateObject.update(query, worker.getWorkerId(), worker.getFirstName(), worker.getLastName(),
                worker.getSalary(), joiningDate, worker.getDepartment(), worker.getEmail());

    }

    public void delete(int workerId) throws SQLException {
        String query = "DELETE FROM Worker WHERE WORKER_ID = ?";
        int res=jdbcTemplateObject.update(query, workerId);
        System.out.println(res+" row deleted!!!");
    }

    public Worker getWorker(int workerId) throws SQLException {
        String query = "SELECT * FROM worker WHERE worker_id=?";
        return jdbcTemplateObject.queryForObject(
                query,
                new Object[] { workerId },
                new WorkerMapper());

    }

    public List<Worker> getWorkers() throws SQLException {
        String query = "SELECT * FROM worker";
        return jdbcTemplateObject.query(
                query,
                new WorkerMapper());
    }

    public void update(Worker emp) throws SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String joiningDate = sdf.format(emp.getJoiningDate());
        String query = "UPDATE worker SET worker_id =?,first_name =?, last_name =?,  salary =?,joining_date = ?,  department = ?,email = ? WHERE worker_id = ? ";
       int res= jdbcTemplateObject.update(query, emp.getWorkerId(), emp.getFirstName(), emp.getLastName(),
                emp.getSalary(), joiningDate, emp.getDepartment(), emp.getEmail(),emp.getWorkerId());
System.out.println(res+" row is updated!!!");
    }
    public static void printAllWorkers(List<Worker> workers) {
		for(Worker worker: workers) {
System.out.println(worker);
		}
}
}