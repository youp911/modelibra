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
package game.swing.app;

import game.swing.rushhour.area.AreasWindow;

import javax.swing.JApplet;

/**
 * Applet or application.
 * 
 * @author Dzenan Ridjanovic
 * @version 2007-09-19
 */
public class Start extends JApplet {

	AreasWindow areasWindow;

	public void init() {
		areasWindow = new AreasWindow();
	}

	public void start() {
		areasWindow.setTitle("Modelibra Rush Hour");
		areasWindow.setVisible(true);
	}

	public void stop() {
		areasWindow.setVisible(false);
	}

	public void destroy() {
		areasWindow.dispose();
	}

	public static void main(String[] args) {
		Start app = new Start();
		app.init();
		app.start();
	}

}
