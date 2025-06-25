import { render, screen, waitFor } from '@testing-library/react';
import axios from 'axios';
import CarsPage from '../CarsPage';

jest.mock('axios');

test('CarsPage fetches and shows list', async () => {
  axios.get.mockResolvedValue({
    data: [{ id: 1, brand: 'Renault', model: 'Clio', pricePerDay: 40, registrationNumber: 'CL-456', status: 'AVAILABLE' }],
  });

  render(<CarsPage />);
  await waitFor(() => expect(screen.getByText(/Renault/i)).toBeInTheDocument());
});
