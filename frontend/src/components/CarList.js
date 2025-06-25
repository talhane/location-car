import React from 'react';

function CarList({ cars, onEdit, onDelete }) {
  return (
    <table className="table">
      <thead>
        <tr>
          <th>Brand</th>
          <th>Model</th>
          <th>Price/Day</th>
          <th>Reg. Number</th>
          <th>Status</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        {cars.map((car) => (
          <tr key={car.id}>
            <td>{car.brand}</td>
            <td>{car.model}</td>
            <td>{car.pricePerDay}</td>
            <td>{car.registrationNumber}</td>
            <td>{car.status}</td>
            <td>
              <button className="btn btn-sm btn-warning" onClick={() => onEdit(car)}>Edit</button>
              <button className="btn btn-sm btn-danger ms-2" onClick={() => onDelete(car.id)}>Delete</button>
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}

export default CarList;
