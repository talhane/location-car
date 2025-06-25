
import { BrowserRouter as Router, Routes, Route, Link ,Navigate } from 'react-router-dom';
import CarsPage from './pages/CarsPage';
import ClientsPage from './pages/ClientsPage';
import RentalsPage from './pages/RentalsPage';
import React, { useState, useEffect } from 'react';
import LoginPage from './pages/LoginPage'; 

function App() {
  const [isAuthenticated, setIsAuthenticated] = useState(false);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const token = window.authToken; 
    if (token) {
      setIsAuthenticated(true);
    }
    setIsLoading(false);
  }, []);


  const handleLoginSuccess = (token) => {
    window.authToken = token;
    setIsAuthenticated(true);
  };

 
  const handleLogout = () => {
    window.authToken = null;
    setIsAuthenticated(false);
  };

 
  if (isLoading) {
    return (
      <div className="min-h-screen flex items-center justify-center">
        <div className="w-8 h-8 border-4 border-blue-600 border-t-transparent rounded-full animate-spin"></div>
      </div>
    );
  }


  if (!isAuthenticated) {
    return <LoginPage onLoginSuccess={handleLoginSuccess} />;
  }

 
  return (
    <Router>
      <div className="min-h-screen bg-gray-50">
        
        <nav className="bg-white shadow-sm border-b">
          <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
            <div className="flex justify-between items-center h-16">
              <div className="flex space-x-8">
                <Link 
                  to="/" 
                  className="text-gray-700 hover:text-blue-600 px-3 py-2 rounded-md text-sm font-medium transition-colors"
                >
                  Cars
                </Link>
                <Link 
                  to="/clients" 
                  className="text-gray-700 hover:text-blue-600 px-3 py-2 rounded-md text-sm font-medium transition-colors"
                >
                  Clients
                </Link>
                <Link 
                  to="/rentals" 
                  className="text-gray-700 hover:text-blue-600 px-3 py-2 rounded-md text-sm font-medium transition-colors"
                >
                  Rentals
                </Link>
              </div>
              
              <button
                onClick={handleLogout}
                className="bg-red-600 hover:bg-red-700 text-white px-4 py-2 rounded-md text-sm font-medium transition-colors"
              >
                Logout
              </button>
            </div>
          </div>
        </nav>

        <main className="max-w-7xl mx-auto py-6 px-4 sm:px-6 lg:px-8">
          <Routes>
            <Route path="/" element={<CarsPage />} />
            <Route path="/clients" element={<ClientsPage />} />
            <Route path="/rentals" element={<RentalsPage />} />
            <Route path="*" element={<Navigate to="/" replace />} />
          </Routes>
        </main>
      </div>
    </Router>
  );
}

export default App;