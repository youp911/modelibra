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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToolBar;

/**
 * A tool bar with the Restart (parking) game.
 * 
 * @author Dzenan Ridjanovic
 * @version 2007-03-21
 */
public class ParkingActionSpace extends JToolBar {

	private JButton restartButton = new JButton("Restart");

	private ParkingWindow parkingWindow;

	private class ParkingInit implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			parkingWindow.initializeParkingSpace();
		}
	}

	public ParkingActionSpace(ParkingWindow parkingWindow) {
		super();

		restartButton.addActionListener(new ParkingInit());
		restartButton.setToolTipText("Initialize Parking Space");

		add(restartButton);
		addSeparator();

		setFloatable(false);

		this.parkingWindow = parkingWindow;
	}

	public ParkingWindow getParkingWindow() {
		return parkingWindow;
	}

}
