package com.vytrack.step_definitions;

import com.vytrack.Student;
import com.vytrack.utilities.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.DataTableType;
import io.cucumber.java.en.Given;
import org.openqa.selenium.Cookie;
import java.util.List;

public class pojoPractice {

    @Given("student say his info")
    public void student_say_his_info(List<Student> dataTable) {

        System.out.println(dataTable.get(0).toString());

    }
    @Given("student say buy")
    public void student_say_buy() {
        System.out.println("Bye");
    }
}
