package com.cydeo.bootstrap;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Gender;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataGenerator implements CommandLineRunner {

    RoleService roleService;
    UserService userService;
    ProjectService projectService;
    public DataGenerator(RoleService roleService, UserService userService, ProjectService projectService){
        this.roleService = roleService;
        this.userService = userService;
        this.projectService = projectService;
    }

    @Override
    public void run(String... args) throws Exception {
        RoleDTO adminRole = new RoleDTO(1L, "Admin");
        RoleDTO managerRole = new RoleDTO(2L, "Manger");
        RoleDTO employeeRole = new RoleDTO(3L, "Employee");

        roleService.save(adminRole);
        roleService.save(managerRole);
        roleService.save(employeeRole);

        UserDTO user1 = new UserDTO("John", "Kesy", "john@cydeo.com", "Abc1", true, "7884561230", managerRole, Gender.MALE);
        UserDTO user2 = new UserDTO("Mike", "Smith", "mike@cydeo.com", "Abc1", true, "8978561231", adminRole, Gender.MALE);
        UserDTO user3 = new UserDTO("Nora", "Johnson", "nora@cydeo.com", "Abc1", true, "4567891234", managerRole, Gender.FEMALE);
        UserDTO user4 = new UserDTO("Lauren", "Brown", "lauren@cydeo.com", "Abc1", true, "1234567891", employeeRole, Gender.FEMALE);
        UserDTO user5 = new UserDTO("Patrick", "Miller", "patrick@cydeo.com", "Abc1", true, "124578369", employeeRole, Gender.MALE);
        UserDTO user6 = new UserDTO("Tasha", "Candy", "tasha@cydeo.com", "Abc1", true, "2354789456", adminRole, Gender.FEMALE);
        UserDTO user7 = new UserDTO("Matt", "Tomas", "matt@cydeo.com", "Abc1", true, "3216549871", employeeRole, Gender.MALE);
        UserDTO user8 = new UserDTO("Jacky", "Sau", "jacky@cydeo.com", "Abc1", true, "5467891234", employeeRole, Gender.FEMALE);

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
        userService.save(user6);
        userService.save(user7);
        userService.save(user8);

        ProjectDTO project1 = new ProjectDTO("Spring MVC","PR001",user1, LocalDate.now(),LocalDate.now().plusDays(25),"Creating Controllers", Status.OPEN);
        ProjectDTO project2 = new ProjectDTO("Spring ORM","PR002",user2, LocalDate.now(),LocalDate.now().plusDays(10),"Creating Database", Status.IN_PROGRESS);
        ProjectDTO project3 = new ProjectDTO("Spring Container","PR003",user1, LocalDate.now(),LocalDate.now().plusDays(32),"Creating Container", Status.IN_PROGRESS);

        projectService.save(project1);
        projectService.save(project2);
        projectService.save(project3);
    }
}
