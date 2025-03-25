import React, { Component } from 'react'
import BookService from '../services/BookService';

export default class BookComponent extends Component {

    constructor(props) {
        super(props)
        this.state = {
                books: []
        }
    }

    componentDidMount(){
        BookService.getBooks().then((res) => {
            this.setState({ books: res.data })
            console.log(this.state.books)
          })
          .catch(function (ex) {
              console.log('Response parsing failed. Error: ', ex);
          });;
    }

    render() {
        return (
            <div>
                <h2 className="text-center">Book Details</h2>
                <table className="table table-striped">
                    <thead>
                        <tr>
                            <th>Book Id</th>
                            <th>Book Title</th>
                            <th>Book Author</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.books.map(
								book =>
                                    <tr key={book.id}>
                                        <td>{book.id}</td>
                                        <td>{book.title}</td>
                                        <td>{book.author}</td>
                                    </tr>
                            )
                        }
                    </tbody>
                </table>
            </div>
        )
    }
}