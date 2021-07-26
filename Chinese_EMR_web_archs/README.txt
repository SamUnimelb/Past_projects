This is a web programming project that demonstrates web programing technologies. 
It simulates the processes of patients / doctor registration, and the process of doctor taking notes.

------------------------------------DISCLAIMER-----------------------------------------------------
This project is only an example for demonstrating a web development project,
any other uses other than demonstration purposes are considered as misuse.
Especially, it was NOT designed to be used for purposes such as real clinical environment.
Any attempt to use this example or build up solutions based on this example for
purposes other than demonstration, are at their own risks, and the developer of this
project will not take any responsibility of any problems or issues caused by
misusing this project.

To start the project, place the whole file under htdocs file of the xampp application,
then start xampp Apache server, as well as your local MySQL database server. You need to modify
the parameters in the file db_connection.php to fit your MySQL database parameters in order to
start the project. Then click the main page, which is index.html and then you can try the demo of the whole project.

Common functions such as login, diagnose records read and write, as well as db connection are put at the same level
as the index page. Programs specific for user registration are put in register. Programs for the clinician side usage are 
put in clinician_progs, and programs for citizen use are put in citizen_progs. 
