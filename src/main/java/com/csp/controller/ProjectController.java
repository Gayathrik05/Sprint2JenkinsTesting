package com.csp.controller;
import com.csp.dto.ProjectDTO;
import com.csp.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@CrossOrigin("http://localhost:4200/")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @PostMapping("/insertProjects")
    public void performInsert(@RequestBody ProjectDTO projectdto) {
        projectService.saveOrUpdateProject(projectdto);
    }
    @PutMapping("/updateProjects")
    public void performUpdate(@RequestBody ProjectDTO projectdto ) {
        projectService.saveOrUpdateProject(projectdto);
    }
    @DeleteMapping("/deleteProjects/{projectId}")
    public void performDelete(@PathVariable ("projectId") Long projectId) {
        projectService.deleteProjectById(projectId);
    }
    @GetMapping("/findAllProjects")
    public List<ProjectDTO> viewAllProjects() {
        return projectService.getAllProjects();
    }
    @GetMapping("/viewProjects/{projectId}")
    public List<ProjectDTO> viewAllProjects(@PathVariable ("projectId")Long projectId) {
        return projectService.getProject(projectId);
    }
    @GetMapping("/getProject/{departmentId}")
    public List<ProjectDTO> getProjects(@PathVariable("departmentId")Long departmentId) {
        return projectService.getParticular( departmentId);
    }
}
