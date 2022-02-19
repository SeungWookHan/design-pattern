// 해당 코드는 Run하기 위해 작성한 코드가 아닌 공부용으로 작성한 것임을 알립니다.

/*
빌더 패턴은 무언가를 조합해주는 패턴.
*/

class Request {
  constructor(url, method, data) {
    this.url = url;
    this.method = method;
    this.data = data;
  }
}

let getRequest = new Request("https://sample.com", "GET", null);
let postRequest = new Request("https://sample.com", "POST", {id: "hg", password: 1234});

/*
여기서의 문제점은, 데이터가 없을 경우 null을 명시적으로 넣어줘야 한다는 점이다.
이런 구조는 새로운 인자가 추가될 경우, 어떤 위치에 어떤 타입의 데이터가 들어가야 하는지 명시적이지 않다.
또한 코드의 길이도 길어지고, 가독성도 좋지 않으며,
유효성 검사를 위해 생성자에 불필요한 코드가 장황하게 들어갈 가능성이 크다.
이러한 것을 빌더 패턴을 통해 해결한다.
*/

class Request {
  constructor() {
    this.url = '';
    this.method = '';
    this.data = null;
  }
}

class RequestBuilder {
  constructor() {
    this.request = new Request();
  }
  
  forUrl(url) {
    this.request.url = url;
    return this;
  }

  useMethod(method){
    this.request.method = method;
    return this;
  }

  setData(data){
    this.request.data = data;
    return this;
  }

  build(){
    return this.request;
  }
}

let getRequest = new RequestBuilder()
  .forUrl("https://sample.com")
  .useMethod("GET")
  .build();

let postRequest = new RequestBuilder()
  .forUrl("https://sample.com")
  .useMethod("POST")
  .setData({
    id: "dad",
    password: 1234
  })
  .build();