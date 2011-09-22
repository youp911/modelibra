/*
 * Modelibra
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package game.swing.rushhour.car;

import game.rushhour.car.Car;
import game.rushhour.parking.CarSpace;
import game.swing.rushhour.parking.ParkingSpace;
import game.swing.rushhour.parking.VehicleSpace;

import javax.swing.JOptionPane;

/**
 * A view of the car.
 * 
 * @author Dzenan Ridjanovic
 * @version 2007-03-21
 */
public class Vehicle {

	private ParkingSpace parkingSpace;

	private Car car;

	public Vehicle(ParkingSpace parkingSpace, Car car) {
		super();
		this.parkingSpace = parkingSpace;
		this.car = car;
		car.setCurrentRow(car.getStartRow());
		car.setCurrentColumn(car.getStartColumn());
	}

	public ParkingSpace getParkingSpace() {
		return parkingSpace;
	}

	public Car getCar() {
		return car;
	}

	public void display() {
		CarSpace carSpace = car.getCurrentSpace();
		VehicleSpace vehicleSpace = parkingSpace.getVehicleSpace(carSpace
				.getRow(), carSpace.getColumn());
		int carLength = car.getLength();
		VehicleSpace nextVehicleSpace = null;

		vehicleSpace.setVehicle(this);
		vehicleSpace.setUsed(true);
		if (car.getParking().getSelectedCar() == car) {
			vehicleSpace.setSelected(true);
		}
		vehicleSpace.display();

		for (int i = 1; i < carLength; i++) {
			if (car.getOrientation().equals("Vertical")) {
				nextVehicleSpace = parkingSpace
						.getNextVerticalVehicleSpace(vehicleSpace);
			} else if (car.getOrientation().equals("Horizontal")) {
				nextVehicleSpace = parkingSpace
						.getNextHorizontalVehicleSpace(vehicleSpace);
			}
			if (nextVehicleSpace != null) {
				nextVehicleSpace.setVehicle(this);
				nextVehicleSpace.setUsed(true);
				if (car.getParking().getSelectedCar() == car) {
					nextVehicleSpace.setSelected(true);
				}
				nextVehicleSpace.display();

				vehicleSpace = nextVehicleSpace;
			}
		}
	}

	public void erase() {
		CarSpace carSpace = car.getCurrentSpace();
		VehicleSpace vehicleSpace = parkingSpace.getVehicleSpace(carSpace
				.getRow(), carSpace.getColumn());
		int carLength = car.getLength();
		VehicleSpace nextVehicleSpace = null;

		vehicleSpace.erase();

		for (int i = 1; i < carLength; i++) {
			if (car.getOrientation().equals("Vertical")) {
				nextVehicleSpace = parkingSpace
						.getNextVerticalVehicleSpace(vehicleSpace);
			} else if (car.getOrientation().equals("Horizontal")) {
				nextVehicleSpace = parkingSpace
						.getNextHorizontalVehicleSpace(vehicleSpace);
			}
			if (nextVehicleSpace != null) {
				nextVehicleSpace.erase();
				vehicleSpace = nextVehicleSpace;
			}
		}
	}

	public void deselect() {
		Car selectedCar = parkingSpace.getParking().getSelectedCar();
		if (selectedCar == car) {
			CarSpace[] carSpaces = selectedCar.getCarSpaces();
			for (int i = 0; i < carSpaces.length; i++) {
				if (selectedCar.getOrientation().equals("Horizontal")) {
					parkingSpace.getVehicleSpace(selectedCar.getCurrentRow(),
							selectedCar.getCurrentColumn() + i).setSelected(
							false);
				} else if (selectedCar.getOrientation().equals("Vertical")) {
					parkingSpace.getVehicleSpace(
							selectedCar.getCurrentRow() + i,
							selectedCar.getCurrentColumn()).setSelected(false);
				}
			}
		}
		parkingSpace.getParking().setSelectedCar(null);
	}

	public void select() {
		parkingSpace.getParking().setSelectedCar(car);
		CarSpace carSpace = car.getCurrentSpace();
		VehicleSpace vehicleSpace = parkingSpace.getVehicleSpace(carSpace
				.getRow(), carSpace.getColumn());
		int carLength = car.getLength();
		VehicleSpace nextVehicleSpace = null;

		vehicleSpace.setSelected(true);
		vehicleSpace.display();

		for (int i = 1; i < carLength; i++) {
			if (car.getOrientation().equals("Vertical")) {
				nextVehicleSpace = parkingSpace
						.getNextVerticalVehicleSpace(vehicleSpace);
			} else if (car.getOrientation().equals("Horizontal")) {
				nextVehicleSpace = parkingSpace
						.getNextHorizontalVehicleSpace(vehicleSpace);
			}
			if (nextVehicleSpace != null) {
				nextVehicleSpace.setSelected(true);
				nextVehicleSpace.display();

				vehicleSpace = nextVehicleSpace;
			}
		}
	}

	public void moveRight() {
		if (parkingSpace.getParking().getSelectedCar() == car) {
			if (car.getOrientation().equals("Horizontal")) {
				CarSpace rearPlusOneSpace = car.getRearPlusOneSpace();
				if (rearPlusOneSpace.getColumn() < ParkingSpace.GRID_SIZE_IN_VEHICLE_SPACES) {
					if (parkingSpace.getParking().isSpaceFree(rearPlusOneSpace)) {
						erase();
						if ((rearPlusOneSpace.getRow() == ParkingSpace.EXIT_ROW)
								& (rearPlusOneSpace.getColumn() == ParkingSpace.EXIT_COLUMN)) {
							JOptionPane.showMessageDialog(parkingSpace
									.getParkingWindow(), "You win!");
						} else {
							car.setCurrentSpace(car.getCurrentSpace()
									.getFurtherHorizontalSpace(1));
							display();
						}
					}
				}
			}
		}
	}

	public void moveLeft() {
		if (parkingSpace.getParking().getSelectedCar() == car) {
			if (car.getOrientation().equals("Horizontal")) {
				CarSpace headMinusOneSpace = car.getHeadMinusOneSpace();
				if (headMinusOneSpace.getColumn() >= 0) {
					if (parkingSpace.getParking()
							.isSpaceFree(headMinusOneSpace)) {
						erase();
						car.setCurrentSpace(car.getCurrentSpace()
								.getFurtherHorizontalSpace(-1));
						display();
					}
				}
			}
		}
	}

	public void moveDown() {
		if (parkingSpace.getParking().getSelectedCar() == car) {
			if (car.getOrientation().equals("Vertical")) {
				CarSpace rearPlusOneSpace = car.getRearPlusOneSpace();
				if (rearPlusOneSpace.getRow() < ParkingSpace.GRID_SIZE_IN_VEHICLE_SPACES) {
					if (parkingSpace.getParking().isSpaceFree(rearPlusOneSpace)) {
						erase();
						car.setCurrentSpace(car.getCurrentSpace()
								.getFurtherVerticalSpace(1));
						display();
					}
				}
			}
		}
	}

	public void moveUp() {
		if (parkingSpace.getParking().getSelectedCar() == car) {
			if (car.getOrientation().equals("Vertical")) {
				CarSpace headMinusOneSpace = car.getHeadMinusOneSpace();
				if (headMinusOneSpace.getRow() >= 0) {
					if (parkingSpace.getParking()
							.isSpaceFree(headMinusOneSpace)) {
						this.erase();
						car.setCurrentSpace(car.getCurrentSpace()
								.getFurtherVerticalSpace(-1));
						this.display();
					}
				}
			}
		}
	}

}