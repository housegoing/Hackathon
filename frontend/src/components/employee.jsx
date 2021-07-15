import React, { Component } from "react";
import employeeService from "../service/employeeService";

class Employee extends Component {
  constructor(props) {
    super(props);

    this.state = {
      employees: [],
    };
  }

  componentDidMount() {
    employeeService.getEmployees().then((res) => {
      this.setState({ employees: res.data });
    });
  }
  render() {
    return (
      <div>
        <h2 className="text-center">Employees</h2>
        <div className="row">
          <table className="table table-striped table-borderd">
            <thead>
              <tr>
                <th> Employee First name </th>
                <th> Employee Last name </th>
                <th> Employee Email ID </th>
                <th> Actions </th>
              </tr>
            </thead>
            <tbody>
              {this.state.employees.map((employee) => (
                <tr key={employee.id}>
                  <td>{employee.firstName}</td>
                  <td>{employee.lastName}</td>
                  <td>{employee.email}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    );
  }
}

export default Employee;
