package com.shinbae.mvc.employeemanagement.controller.mvc;

import com.shinbae.mvc.employeemanagement.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/employees-mvc")
@RequiredArgsConstructor
@Slf4j
public class EmployeeMVCController {
    private final EmployeeService employeeService;

    @GetMapping("/list-employees")
    public ModelAndView listEmployees() {
        log.info("listEmployees()");
        ModelAndView modelAndView = new ModelAndView("employees-mvc/list-employees");
        modelAndView.addObject("employees",employeeService.getEmployees());
        return modelAndView;
    }
}
