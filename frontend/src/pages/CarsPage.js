import React, { useEffect, useState } from 'react';
import api from '../services/api';
import CarList from '../components/CarList';
import CarForm from '../components/CarForm';

function CarsPage() {
  const [cars, setCars] = useState([]);
  const [carToEdit, setCarToEdit] = useState(null);

  const fetchCars = async () => {
    const res = await api.get('/cars');
    setCars(res.data);
  };

  const addOrUpdateCar = async (car) => {
    if (car.id) {
      await api.put(`/cars/${car.id}`, car);
    } else {
      await api.post('/cars', car);
    }
    fetchCars();
  };

  const deleteCar = async (id) => {
    await api.delete(`/cars/${id}`);
    fetchCars();
  };

  useEffect(() => {
    fetchCars();
  }, []);

  return (
    <div className="container mt-4">
      <h2>Car Management</h2>
      <CarForm onSubmit={addOrUpdateCar} carToEdit={carToEdit} resetEdit={() => setCarToEdit(null)} />
      <CarList cars={cars} onEdit={setCarToEdit} onDelete={deleteCar} />
    </div>
  );
}

export default CarsPage;
