# Assembly Line Application

Application to adjust assembly lines using follow below constraints:

-  Don't use plugins utilities or frameworks for date calculations (e.g. Joda-Time)

- Use input.txt as the system input data file.
- The production has multiple assembly lines and each one has the morning, lunch and afternoon periods.
- Each period has multiple steps of the production process. Obviously the lunch period doesn't have them.
- The morning period begins at 9:00 am and must finish by 12:00 noon, for lunch.
- The afternoon period begins at 1:00 pm and must finish in time for the labor gymnastics activities.
- The labor gymnastics activities can start no earlier than 4:00 pm and no later than 5:00 pm.
- The production step titles don't have numbers in it.
- All the numbers in the production step titles are the step time in minutes or the word "maintenance" which one represents a 5 minutes of technical pause.
- It won't have interval between the process steps



## Built With

- Spring Boot
- JUnit
- DDD
- CleanCode



## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 



### Download the repository

- Download the zip or clone de Git repository
- Unzip the zip file (if you downloaded one)



### Running the application with Command Prompt

- Open Command Prompt and navigate to folder assembly-app
- Run the command below

```shell
mvn spring-boot:run
```

OR

- Open Command Prompt and navigate to folder assembly-app/target
- Run the command below

```shell
java -jar assemblyline-0.0.1-SNAPSHOT.jar
```



### Running the application with IDE

- Open the IDE
- Import a existing projetc
- Navigate to the folder where you unzipped the zip
- Select the Project
- Choose the Spring Boot Application file (ConsoleApplication)
- Right Click on the file and Run



## Contact

- Vicente Júnior - [LinkedIn](https://www.linkedin.com/in/vicente-jr-41787963/) - vicente.junior@live.com 
