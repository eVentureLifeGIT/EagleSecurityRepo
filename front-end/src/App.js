import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link, useNavigate, Outlet } from 'react-router-dom';
import BookComponent from './components/BookComponent';
import Home from './components/Home';
import About from './components/About';
import Contact from './components/Contact';
import './App.css';

function App() {
  return (  
    <Router>
		<Routes>
			<Route path="/" element={<Home/>}/>
			<Route path="/about" element={<About/>}/>
			<Route path="/contact" element={<Contact/>}/>
			<Route path="/books" element={<BookComponent/>}/>
		</Routes>	  
    </Router>
  );
}

export default App;
