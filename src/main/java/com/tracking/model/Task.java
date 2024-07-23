package com.tracking.model;



import java.sql.Date;

public class Task {
    private int taskId;
    private String taskName;
    private String taskDescription;
    private int taskAssignedTo; // Assuming this is an integer ID
    private Date taskStartDate; // Change to String if storing as String in database
    private Date taskEndDate; // Change to String if storing as String in database
    private String taskStatus;

    // Constructor for adding new task
    public Task(String taskName, String taskDescription, int taskAssignedTo, Date taskStartDate, Date taskEndDate, String taskStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskAssignedTo = taskAssignedTo;
        this.taskStartDate = taskStartDate;
        this.taskEndDate = taskEndDate;
        this.taskStatus = taskStatus;
    }

    // Constructor for updating task
    public Task(int taskId, String taskName, String taskDescription, int taskAssignedTo, Date taskStartDate, Date taskEndDate, String taskStatus) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskAssignedTo = taskAssignedTo;
        this.taskStartDate = taskStartDate;
        this.taskEndDate = taskEndDate;
        this.taskStatus = taskStatus;
    }

    // Getters and setters omitted for brevity
    


	public Task(int int1, String string, String string2, Date date, Date date2, String string3) {
		// TODO Auto-generated constructor stub
	}

	
	public Task(Object setTaskId) {
		// TODO Auto-generated constructor stub
	}

	public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public int getTaskAssignedTo() {
        return taskAssignedTo;
    }

    public void setTaskAssignedTo(int taskAssignedTo) {
        this.taskAssignedTo = taskAssignedTo;
    }

    public Date getTaskStartDate() {
        return taskStartDate;
    }

    public void setTaskStartDate(Date taskStartDate) {
        this.taskStartDate = taskStartDate;
    }

    public Date getTaskEndDate() {
        return taskEndDate;
    }

    public void setTaskEndDate(Date taskEndDate) {
        this.taskEndDate = taskEndDate;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    // toString() method for debugging and logging
    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", taskAssignedTo=" + taskAssignedTo +
                ", taskStartDate=" + taskStartDate +
                ", taskEndDate=" + taskEndDate +
                ", taskStatus='" + taskStatus + '\'' +
                '}';
    }
}
