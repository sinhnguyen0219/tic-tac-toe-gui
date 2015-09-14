cd acceptance
javac -cp .;..\src TicTacToe
java -cp .;..\build\classes\main;C:\RobotFramework\robotframework-2.9.jar org.robotframework.RobotFramework TicTacToeTests.txt
cd ..

