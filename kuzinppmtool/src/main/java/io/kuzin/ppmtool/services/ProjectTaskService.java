package io.kuzin.ppmtool.services;

import io.kuzin.ppmtool.domain.Backlog;
import io.kuzin.ppmtool.domain.ProjectTask;
import io.kuzin.ppmtool.repositories.BacklogRepository;
import io.kuzin.ppmtool.repositories.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskService {

    @Autowired
    private BacklogRepository backlogRepository;

    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask){

        Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier);

        projectTask.setBacklog(backlog);

        Integer backlogSequence = backlog.getPTSequence();
        backlogSequence++;

        projectTask.setProjectSequence(projectIdentifier + "-" + backlogSequence);
        projectTask.setProjectIdentifier(projectIdentifier);

        /*if(projectTask.getPriority() == 0 || projectTask.getPriority() == null){
            projectTask.setPriority(3);
        }*/
        if(projectTask.getStatus() == "" || projectTask.getStatus() == null){
            projectTask.setStatus("TO_DO");
        }

        return projectTaskRepository.save(projectTask);
    }


}
