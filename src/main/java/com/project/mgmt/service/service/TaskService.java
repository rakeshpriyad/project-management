package com.project.mgmt.service.service;

import com.project.mgmt.service.domain.Party;
import com.project.mgmt.service.domain.Task;
import com.project.mgmt.service.dto.TaskRequest;
import com.project.mgmt.service.repository.PartyRepository;
import com.project.mgmt.service.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.project.mgmt.service.utils.RepositoryUtils.getTask;

@Service
public class TaskService {

    private TaskRepository taskRepository;
    private PartyRepository partyRepository;
    public TaskService(TaskRepository taskRepository, PartyRepository partyRepository) {
        this.taskRepository = taskRepository;
        this.partyRepository = partyRepository;
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Optional<Task> save(TaskRequest request) {
        Optional<Party> party = partyRepository.findById(request.getPartyId());
        Task task = getTask(request.getTaskId(), request.getTaskName(), party.get());
        return Optional.ofNullable(taskRepository.save(task));
    }

    public Optional<Task> update(TaskRequest request) {
        Optional<Party> party = partyRepository.findById(request.getPartyId());
        Task task = getTask(request.getTaskId(), request.getTaskName(), party.get());
        return Optional.ofNullable(taskRepository.save(task));
    }

    public   TaskRequest getTaskRequest(Long taskId, String taskName, Long partyId){
        return TaskRequest.builder().taskId(taskId).taskName(taskName).partyId(partyId).build();
    }
}

