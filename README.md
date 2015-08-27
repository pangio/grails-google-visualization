# Groovy/Grails sample app

The application represents a company with employees. The employees are 'hired' and 'fired' randomly via Quarty jobs and persisted into a in-memory DB.
The information pulled from the DB to be shown into the ```List``` and ```Charts``` is updated via ajax.


# Tech Stack
*  Grails 2.3.7
*  Spring Security
*  Google Visualization API (charts)

# Prerequisites
* Grails 2.3.7

# Tests
* They can be found under the test source folder


# Login

```
username: admin
password: pass
```

![Alt text](/screenshots/ss1 login.png?raw=true "Login")

# Employees list
Just browse [http://localhost:8090/company](http://localhost:8090/company)

![Alt text](/screenshots/ss2 list.png?raw=true "Employees list")

# Charts
Just browse [http://localhost:8090/company/charts](http://localhost:8090/company/charts)

![Alt text](/screenshots/ss3 pie chart.png?raw=false "Pie Chart")
![Alt text](/screenshots/ss4 bar chart.png?raw=false "Bar Chart")
![Alt text](/screenshots/ss5 map.png?raw=false "Map Chart")
