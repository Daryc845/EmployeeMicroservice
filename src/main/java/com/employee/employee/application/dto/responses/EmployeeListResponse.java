package com.employee.employee.application.dto.responses;

import java.util.List;

public class EmployeeListResponse {
    private boolean success;
    private String message;
    private List<EmployeeListItemResponse> data;

    public EmployeeListResponse(boolean success, String message, List<EmployeeListItemResponse> data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
    public List<EmployeeListItemResponse> getData() { return data; }
}
