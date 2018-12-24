package com.shekhar.projector;

import com.shekhar.projector.domain.*;
import com.shekhar.projector.repositories.*;
import com.shekhar.projector.repositories.grading.AnswerRepository;
import com.shekhar.projector.repositories.grading.QuestionRepository;
import com.shekhar.projector.repositories.grading.ReviewFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;

@SpringBootApplication
public class ProjectorApplication implements ApplicationRunner{


	@Autowired
	private DesignationRepository designationRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private ProjectResourceRepository projectResourceRepository;

	@Autowired
	private TaskLogRepository taskLogRepository;

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private TaskStatusRepository taskStatusRepository;

	@Autowired
	private TaskTypeRepository taskTypeRepository;

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@Autowired
	private ReviewFormRepository reviewFormRepository;

	//@Autowired private ProjectItemProcessor projectItemProcessor;

	private void feedData(){

		//Designation
		Designation designationDeveloper = new Designation("Developer");
		Designation designationTester = new Designation("Tester");
		Designation designationManager = new Designation("Manager");
		designationRepository.save(designationDeveloper);
		designationRepository.save(designationTester);
		designationRepository.save(designationManager);

		//Employee
		Employee employeeArun = new Employee("E00771", "Arun Bhardwaj", "arun@gmail.com", designationManager);
		Employee employeeShekhar = new Employee("E00772", "Shekhar Kumar", "shekhar@gmail.com", designationDeveloper);
		Employee employeeVibhav = new Employee("E00773", "Vibhav Gupta", "vibha@gmail.com", designationTester);

		employeeRepository.save(employeeArun);
		employeeRepository.save(employeeShekhar);
		employeeRepository.save(employeeVibhav);

		//Project
		Project projectPPL = new Project("PPLMotorHomes");
		projectPPL.setCreated(Calendar.getInstance().getTime());

		Project projectPearson = new Project("PearsonIngenico");
		projectPearson.setCreated(Calendar.getInstance().getTime());

		projectRepository.save(projectPPL);
		projectRepository.save(projectPearson);


		//ProjectResource
		ProjectResource pplProjectResourceArun = new ProjectResource(employeeArun, designationManager, Calendar.getInstance().getTime(), employeeArun);
		ProjectResource pplProjectResourceShekhar = new ProjectResource(employeeShekhar, designationDeveloper, Calendar.getInstance().getTime(), employeeArun);
		ProjectResource pplProjectResourceVibhav = new ProjectResource(employeeVibhav, designationTester, Calendar.getInstance().getTime(), employeeArun);

		projectResourceRepository.save(pplProjectResourceArun);
		projectResourceRepository.save(pplProjectResourceShekhar);
		projectResourceRepository.save(pplProjectResourceVibhav);

		ProjectResource pearsonProjectResourceArun = new ProjectResource(employeeArun, designationManager, Calendar.getInstance().getTime(), employeeArun);
		ProjectResource pearsonProjectResourceShekhar = new ProjectResource(employeeShekhar, designationDeveloper, Calendar.getInstance().getTime(), employeeArun);

		projectResourceRepository.save(pearsonProjectResourceArun);
		projectResourceRepository.save(pearsonProjectResourceShekhar);

		//Resource allocation to project
		projectPPL.addResource(pplProjectResourceArun);
		projectPPL.addResource(pplProjectResourceShekhar);
		projectPPL.addResource(pplProjectResourceVibhav);
		projectRepository.save(projectPPL);

		projectPearson.addResource(pearsonProjectResourceArun);
		projectPearson.addResource(pearsonProjectResourceShekhar);
		projectRepository.save(projectPearson);


		//TaskType
		TaskType taskTypeDevelopment = new TaskType("Development");
		TaskType taskTypeTesting = new TaskType("Testing");
		TaskType taskTypeManagement = new TaskType("Management");

		taskTypeRepository.save(taskTypeDevelopment);
		taskTypeRepository.save(taskTypeTesting);
		taskTypeRepository.save(taskTypeManagement);

		//TaskStatus
		TaskStatus taskStatusNotStarted = new TaskStatus("Not Started");
		TaskStatus taskStatusStarted = new TaskStatus("Started");
		TaskStatus taskStatusInProgress = new TaskStatus("InProgress");
		TaskStatus taskStatusCompleted = new TaskStatus("Completed");

		taskStatusRepository.save(taskStatusNotStarted);
		taskStatusRepository.save(taskStatusStarted);
		taskStatusRepository.save(taskStatusInProgress);
		taskStatusRepository.save(taskStatusCompleted);

		//Task
		Task task1 = new Task();
		task1.setName("Requirement Analysis");
		task1.setAssignee(employeeShekhar);
		task1.setAssignedBy(employeeArun);
		task1.setCreatedOn(Calendar.getInstance().getTime());
		task1.setStatus(taskStatusNotStarted);
		task1.setTaskType(taskTypeManagement);
		taskRepository.save(task1);


		projectPPL.addTask(task1);
		projectRepository.save(projectPPL);
	}

	public static void main(String[] args) {
		SpringApplication.run(ProjectorApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
		feedData();
		projectRepository.findAll().forEach(System.out::println);
	}
}
