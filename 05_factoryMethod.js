// 해당 코드는 Run하기 위해 작성한 코드가 아닌 공부용으로 작성한 것임을 알립니다.

class CafeLatte {
  constructor() {
    this.price = 3000;
  }

  getPrice() {
    return this.price;
  }
}
let latte = new CafeLatte();
console.log(latte.getPrice()); // 3000

/*
getPrice(), 라떼의 종류가 하나일 때는 별로 문제가 되지 않지만, 새로운 종류의 라떼를 추가한다면?
*/

class CafeLatte {
  constructor() {
    this.price = 3000;
  }

  getPrice() {
    return this.price;
  }
}

class CaramelLatte {
  constructor() {
    this.price = 5000;
  }

  getPrice() {
    return this.price;
  }
}

let latte;
let latteType = "caramel";

if(latteType === "cafe") {
  latte = new CafeLatte();
} else if(latteType === "caramel") {
  latte = new CaramelLatte();
}

latte.getPrice(); // 5000

// 팩토리 구현
// 이상 동일

class LatteFactory() {
  static create(latteType){
    if(latteType === "cafe") {
      return new CafeLatte();
    } else if(latteType === "caramel") {
      return new CaramelLatte();
    }
  }
}

let latte = LatteFactory.create("caramel");
latte.getPrice(); // 5000

/*
팩토리를 만들어 create() 메서드에 타입을 받아 인스턴스 생성
구체화 하는 로직을 묶음 = 응집도를 높임
부모 클래스에게 알려지지 않은 구체 클래스를 자식 클래스가 결정하도록 하는 패턴!
*/