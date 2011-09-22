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
package game.swing.rushhour.parking;

import game.rushhour.parking.Parking;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * A window with the parking and its tool bar.
 * 
 * @author Dzenan Ridjanovic
 * @version 2007-03-21
 */
public class ParkingWindow extends JFrame {

	private JPanel parkingBoard;

	private ParkingActionSpace parkingActionSpace = new ParkingActionSpace(this);

	private ParkingSpace parkingSpace;

	private Parking parking;

	public ParkingWindow(Parking parking) {
		super();

		this.parking = parking;

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				close();
			}
		});

		parkingSpace = new ParkingSpace(this, parking);

		parkingBoard = new JPanel();
		parkingBoard.setLayout(new BorderLayout());
		parkingBoard.add(parkingSpace, "North");
		parkingBoard.add(parkingActionSpace, "South");

		setContentPane(parkingBoard);
		pack();
	}

	public Parking getParking() {
		return parking;
	}

	public void initializeParkingSpace() {
		parkingSpace.display();
	}

	public void close() {
		dispose();
	}

}