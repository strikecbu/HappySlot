# Happy Slot Machine

## How to Use it
* this project is a maven project, make sure you already install maven.

1. Checkout the project.
2. Use maven clean and compile with project.`mvn clean compile`
3. Use maven plugin to excut main without arguments: `mvn exec:java -Dexec.mainClass="App"`
4. With arguments, you can use with arguments command:
`mvn exec:java -Dexec.mainClass="App" -Dexec.args="number"`
First argument means the bet of you buy.
5. You will see the result print to screen.