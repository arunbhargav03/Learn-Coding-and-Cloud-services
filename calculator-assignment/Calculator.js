// Function to add two numbers
function add(num1, num2) {
  return num1 + num2;
}

// Function to subtract two numbers
function subtract(num1, num2) {
  return num1 - num2;
}

// Function to multiply two numbers
function multiply(num1, num2) {
  return num1 * num2;
}

// Function to divide two numbers
function divide(number1, number2) {
  return number1 / number2;
}

// Function to get input from the user
function getInput(message) {
  return parseFloat(prompt(message));
}

// Function to calculate the result based on the operator
function calculate() {
  const num1 = getInput("Enter the First number: ");
  const num2 = getInput("Enter the Second number: ");
  const operator = prompt("Enter the operator (+, -, *, /): ");

  let output;

  switch (operator) {
    case "+":
      output = add(number1, number2);
      break;
    case "-":
      output = subtract(number1, number2);
      break;
    case "*":
      output = multiply(number1, number2);
      break;
    case "/":
      output = divide(number1, number2);
      break;
    default:
      output = "Invalid operator";
  }

  alert("Result: " + output);
}

// Call the calculate function
calculate();
