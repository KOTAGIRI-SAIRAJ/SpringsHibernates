package com.sb.dao;

import com.sb.model.Task;

import java.util.List;

public interface TaskDAO {

    public void addTask(Task task);

    public List<Task> getAllTasks();

    public void deleteTask(Integer taskId);

    public Task updateTask(Task task);

    public Task getTask(int taskId);
}
