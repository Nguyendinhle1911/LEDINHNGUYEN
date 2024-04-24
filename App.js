import React, { useState } from 'react';

const App = () => {
  const [books, setBooks] = useState([]);
  const [newBook, setNewBook] = useState({
    title: '',
    author: '',
   
  });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setNewBook({ ...newBook, [name]: value });
  };

  const handleAddBook = () => {
    
    if (!newBook.title || !newBook.author) {
      alert('Please fill in all fields.');
      return;
    }

   
    setBooks([...books, newBook]);

   
    setNewBook({
      title: '',
      author: '',
     
    });

   
    alert('New book added!');
  };

  return (
    <div>
      <h1>Add a new book</h1>
      <div>
        <label>Title:</label>
        <input type="text" name="title" value={newBook.title} onChange={handleInputChange} />
      </div>
      <div>
        <label>Author:</label>
        <input type="text" name="author" value={newBook.author} onChange={handleInputChange} />
      </div>
     

      <button onClick={handleAddBook}>Add Book</button>

      <h2>All Books</h2>
      <ul>
        {books.map((book, index) => (
          <li key={index}>{`${book.title} by ${book.author}`}</li>
        ))}
      </ul>
    </div>
  );
};

export default App;