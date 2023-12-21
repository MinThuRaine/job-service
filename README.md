# job-service


## Run With IDE

1. clean & install maven
2. Run Spring Boot Application ( Default Port is :: 8080 )

## API 
* **Sort** & **reqdt** must be comma separated value => 
   eg. reqdt =>(jobTitle,timestamp,employer,salary,gender)
   eg. Sort =>(jobTitle,gender,salary)

* Salary Filter Operation => gt(greater than), ls( less than), eq(equal), gteq(greater than or equal), lseq( less than or equal ), nq(not equal)



Sample Test Get Request Api ==> `http://localhost:8080/api/v1/job_data?jobTitle=Software Developer&reqdt=jobTitle,timestamp,employer,salary,gender&salary=40000&filter=gt&gender=Male&sortType=desc&sort=jobTitle,gender,salary`