package io.kuzin.ppmtool.services;

import io.kuzin.ppmtool.domain.Project;
import io.kuzin.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){

        // more logic here

        return projectRepository.save(project);
    }

}
