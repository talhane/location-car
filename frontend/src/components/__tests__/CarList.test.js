import { render, screen, fireEvent } from '@testing-library/react';
import CarList from '../CarList';

describe('CarList component', () => {
  const cars = [
    { id: 1, brand: 'Tesla', model: '3', pricePerDay: 99, registrationNumber: 'TES-123', status: 'AVAILABLE' },
  ];

  test('renders car brand & actions', () => {
    render(<CarList cars={cars} onEdit={() => {}} onDelete={() => {}} />);
    expect(screen.getByText(/Tesla/i)).toBeInTheDocument();
    expect(screen.getByRole('button', { name: /edit/i })).toBeInTheDocument();
  });

  test('delete button callback fires with id', () => {
    const onDelete = jest.fn();
    render(<CarList cars={cars} onEdit={() => {}} onDelete={onDelete} />);
    fireEvent.click(screen.getByRole('button', { name: /delete/i }));
    expect(onDelete).toHaveBeenCalledWith(1);
  });
});
