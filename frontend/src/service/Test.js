import axios from "axios";

const HACKEDU_URL = "http://localhost:8080/";

class Test {
  addUser() {
      return axios.post(HACKEDU_URL + "/addPublisher", {
          "email":"email@email.com",
          "firstName":"Helllo",
          "lastName":"wow",
      });
  }
}

export default new Test();