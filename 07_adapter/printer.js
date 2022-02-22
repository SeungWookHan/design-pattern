export default class Printer {
  constructor() {
    this.textArr = [];
  }

  pushText(text) {
    this.textArr.push(text);
  }

  print() {
    return this.textArr.join(' ');
  }
}
