class HashTagAdapter {
  constructor(hashTagPrinter) {
    this.printer = hashTagPrinter
  }

  pushText(text) {
    this.printer.pushText(text);
  }

  print() {
    return this.printer.printWithHash(); // 220 -> 110v 변환
  }
}