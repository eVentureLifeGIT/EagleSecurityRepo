import axios from 'axios';

const BOOK_API_REST_URL = "http://localhost:8080/api/books";

class BookService {
    getBooks(){
        return axios.get(BOOK_API_REST_URL);
    }
}
export default new BookService();