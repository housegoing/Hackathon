import axios from 'axios';

const Publisher_URL = "http://localhost:8080/addPublisher"

export interface publisherDetail {
    email: string,
    firstName: string,
    lastName: string
}


class UserService {

    addPublisher() {

      axios.post(Publisher_URL, {
        "email": "email@email.com",
        "firstName": "firstname",
        "lastName": "lastName",
      })
    }

}

export default new UserService;

