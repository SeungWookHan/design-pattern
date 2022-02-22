export default class HashTagPrinter {
  constructor() {
    this.textArr = [];
  }

  pushText(text) {
    this.textArr.push(text);
  }

  printWithHashTag() {
    return this.textArr.map(text => `#${text}`).join(' ');
  }
}