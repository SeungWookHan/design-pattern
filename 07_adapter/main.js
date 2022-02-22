import Printer from './printer.js'

let printer = new Printer();
printer.pushText("Hello");
printer.pushText("Test");
printer.pushText("Pattern");

let result = printer.print();
console.log(result)