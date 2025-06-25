import React, { useState, useEffect } from 'react';

function CarForm({ onSubmit, carToEdit, resetEdit }) {
  const [car, setCar] = useState({
    brand: '',
    model: '',
    pricePerDay: '',
    registrationNumber: '',
    status: '',
  });

  useEffect(() => {
    if (carToEdit) setCar(carToEdit);
  }, [carToEdit]);

  const handleChange = (e) => {
    setCar({ ...car, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    onSubmit(car);
    setCar({ brand: '', model: '', pricePerDay: '', registrationNumber: '', status: '' });
    resetEdit();
  };

  return (
    <form onSubmit={handleSubmit}>
      <div className="row">
        {['brand', 'model', 'registrationNumber'].map((field) => (
          <div className="col-md-3" key={field}>
            <input
              type="text"
              name={field}
              value={car[field]}
              onChange={handleChange}
              className="form-control mb-2"
              placeholder={field}
              required
            />
          </div>
        ))}

        {/* Status Dropdown */}
        <div className="col-md-3">
          <select
            name="status"
            value={car.status}
            onChange={handleChange}
            className="form-control mb-2"
            required
          >
            <option value="">Select Status</option>
            <option value="AVAILABLE">Available</option>
            <option value="RENTED">Rented</option>
            <option value="MAINTENANCE">Maintenance</option>
          </select>
        </div>

        <div className="col-md-2">
          <input
            type="number"
            name="pricePerDay"
            value={car.pricePerDay}
            onChange={handleChange}
            className="form-control mb-2"
            placeholder="Price/Day"
            required
          />
        </div>

        <div className="col-md-1">
          <button type="submit" className="btn btn-primary w-100">
            {carToEdit ? 'Update' : 'Add'}
          </button>
        </div>
      </div>
    </form>
  );
}

export default CarForm;
